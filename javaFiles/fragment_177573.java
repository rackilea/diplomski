@BeforeEach
public void setUp() throws Exception {
    super.setUp();
    ClassLoader classLoader = getClass().getClassLoader();
    URL url = classLoader.getResource(TEST_POM);
    if (url == null) {
        throw new MojoExecutionException(String.format(
                "Cannot locate %s", TEST_POM));
    }
    File pom = new File(url.getFile());
    Settings settings = getMavenSettings();
    if (settings.getLocalRepository() == null) {
        settings.setLocalRepository(
                org.apache.maven.repository.RepositorySystem
                        .defaultUserLocalRepository.getAbsolutePath());
    }
    MavenExecutionRequest request = new DefaultMavenExecutionRequest();
    request.setPom(pom);
    ArtifactRepository artifactRepository =
            new org.apache.maven.artifact.repository.
                    DefaultArtifactRepository(
                    "id", settings.getLocalRepository(),
                    new DefaultRepositoryLayout());
    request.setLocalRepository(artifactRepository);
    MavenExecutionRequestPopulator populator =
            getContainer().lookup(MavenExecutionRequestPopulator.class);
    populator.populateFromSettings(request, settings);
    DefaultMaven maven = (DefaultMaven)
            getContainer().lookup(Maven.class);
    DefaultRepositorySystemSession repositorySystemSession =
            (DefaultRepositorySystemSession)
                    maven.newRepositorySession(request);
    SimpleLocalRepositoryManagerFactory factory =
            new SimpleLocalRepositoryManagerFactory();
    LocalRepositoryManager localRepositoryManager =
            factory.newInstance(repositorySystemSession,
                    new LocalRepository(settings.getLocalRepository()));
    repositorySystemSession.setLocalRepositoryManager(
            localRepositoryManager);
    ProjectBuildingRequest buildingRequest =
            request.getProjectBuildingRequest()
                    .setRepositorySession(repositorySystemSession)
                    .setResolveDependencies(true);
    ProjectBuilder projectBuilder = lookup(ProjectBuilder.class);
    ProjectBuildingResult projectBuildingResult =
            projectBuilder.build(pom, buildingRequest);
    MavenProject project = projectBuildingResult.getProject();
    MavenSession session = new MavenSession(getContainer(),
            repositorySystemSession, request,
            new DefaultMavenExecutionResult());
    session.setCurrentProject(project);
    session.setProjects(Collections.singletonList(project));
    request.setSystemProperties(System.getProperties());
    testMojo = (GenerateConfig) lookupConfiguredMojo(session,
            newMojoExecution("configure"));
    testMojo.getLog().debug(String.format("localRepo = %s",
            request.getLocalRepository()));
    copyTestProjectResourcesToTarget(getContainer(), project, session);
    resolveConfigurationFromRepo(repositorySystemSession, project);
}

private Settings getMavenSettings()
        throws ComponentLookupException,
            IOException,
            XmlPullParserException {
    org.apache.maven.settings.MavenSettingsBuilder mavenSettingsBuilder
            = (org.apache.maven.settings.MavenSettingsBuilder)
                getContainer().lookup(
                    org.apache.maven.settings.MavenSettingsBuilder.ROLE);
    return mavenSettingsBuilder.buildSettings();
}

/**
 * This is ugly but there seems to be no other way to accomplish it. The
 * artifact that the mojo finds on its own will not resolve to a jar file
 * on its own in the test harness. So we use aether to resolve it, by
 * cloning the maven default artifact into an aether artifact and feeding
 * an artifact request to the repo system obtained by the aether service
 * locator.
 */
private void resolveConfigurationFromRepo(
        DefaultRepositorySystemSession repositorySystemSession,
        MavenProject project)
        throws ArtifactResolutionException, MojoExecutionException {
    org.apache.maven.artifact.Artifact defaultArtifact =
            testMojo.getConfigArtifact();
    Artifact artifact = new DefaultArtifact(
            defaultArtifact.getGroupId(),
            defaultArtifact.getArtifactId(),
            null,
            defaultArtifact.getType(),
            defaultArtifact.getVersion());
    List<RemoteRepository> remoteArtifactRepositories =
            project.getRemoteProjectRepositories();
    DefaultServiceLocator locator =
            MavenRepositorySystemUtils.newServiceLocator();
    locator.addService(RepositoryConnectorFactory.class,
            BasicRepositoryConnectorFactory.class);
    locator.addService(TransporterFactory.class,
            FileTransporterFactory.class);
    locator.addService(TransporterFactory.class,
            HttpTransporterFactory.class);
    RepositorySystem repositorySystem = locator.getService(
            RepositorySystem.class);
    ArtifactRequest artifactRequest = new ArtifactRequest();
    artifactRequest.setArtifact(artifact);
    artifactRequest.setRepositories(remoteArtifactRepositories);
    ArtifactResult result = repositorySystem.resolveArtifact(
            repositorySystemSession, artifactRequest);
    defaultArtifact.setFile(result.getArtifact().getFile());
    testMojo.getLog().debug( "Resolved artifact " + artifact + " to " +
            result.getArtifact().getFile() + " from "
            + result.getRepository() );
}


/**
 * Need manual copy of resources because only parts of the maven lifecycle
 * happen automatically with this test harness.
 */
private void copyTestProjectResourcesToTarget(PlexusContainer container,
                                              MavenProject project,
                                              MavenSession session)
        throws ComponentLookupException, MojoExecutionException {
    Optional<Dependency> resourcesPluginDepOpt =
            project.getDependencies().stream()
                    .filter(d -> Objects.equals(d.getArtifactId(),
                            MAVEN_RESOURCES_ARTIFACT_ID))
                    .findFirst();
    // don't want to define the version here so we read it from what we have
    if (!resourcesPluginDepOpt.isPresent()) {
        throw new MojoExecutionException("Require " +
                MAVEN_RESOURCES_ARTIFACT_ID);
    }
    Plugin resourcePlugin = MojoExecutor.plugin(
            MojoExecutor.groupId(MAVEN_PLUGINS_GROUP_ID),
            MojoExecutor.artifactId(MAVEN_RESOURCES_ARTIFACT_ID),
            MojoExecutor.version(resourcesPluginDepOpt.get().getVersion()));
    MojoExecutor.executeMojo(resourcePlugin,
            MojoExecutor.goal("resources"),
            MojoExecutor.configuration(),
            MojoExecutor.executionEnvironment(
                    project, session,
                    container.lookup(BuildPluginManager.class)));
}