/**
    * The project currently being built.
    *
    * @parameter expression="${project}"
    * @readonly
    * @required
    */
    private MavenProject project;

    /** @parameter expression="${localRepository}" */
    protected ArtifactRepository m_localRepository;

    /**@parameter default-value="${localRepository}" */
    private org.apache.maven.artifact.repository.ArtifactRepository
        localRepository;

    /** @parameter default-value="${project.remoteArtifactRepositories}" */
    private java.util.List remoteRepositories;

    /** @component */
    private org.apache.maven.artifact.factory.ArtifactFactory artifactFactory;

    /** @component */
    private org.apache.maven.artifact.resolver.ArtifactResolver resolver;