public static IProject createBareCProject(String name) throws Exception {
    IProject bareProjectHandle = ResourcesPlugin.getWorkspace().getRoot().getProject(name);
    IProjectDescription description =
        bareProjectHandle.getWorkspace().newProjectDescription("TestProject");

    description.setLocationURI(bareProjectHandle.getLocationURI() );

    IProject bareProject =
        CCorePlugin.getDefault().createCDTProject(description, bareProjectHandle, new NullProgressMonitor() );

    IManagedBuildInfo buildInfo = ManagedBuildManager.createBuildInfo(bareProject);
    IManagedProject projectManaged =
        ManagedBuildManager
            .createManagedProject(bareProject, 
                                  ManagedBuildManager.getExtensionProjectType("cdt.managedbuild.target.gnu.mingw.exe") );

    List<IConfiguration> configs = getValidConfigsForPlatform();
    IConfiguration config = 
        projectManaged.createConfiguration(
                configs.get(0), 
                ManagedBuildManager.calculateChildId(configs.get(0).getId(), null));

    ICProjectDescription cDescription = 
        CoreModel.getDefault().getProjectDescriptionManager().createProjectDescription(bareProject, false);

    ICConfigurationDescription cConfigDescription = 
        cDescription.createConfiguration(ManagedBuildManager.CFG_DATA_PROVIDER_ID, config.getConfigurationData() );

    cDescription.setActiveConfiguration(cConfigDescription);
    cConfigDescription.setSourceEntries(null);
    IFolder srcFolder = bareProject.getFolder("src");
    srcFolder.create(true, true, null);
    ICSourceEntry srcFolderEntry = new CSourceEntry(srcFolder, null, ICSettingEntry.RESOLVED);
    cConfigDescription.setSourceEntries(new ICSourceEntry[] { srcFolderEntry });

    buildInfo.setManagedProject(projectManaged);

    cDescription.setCdtProjectCreated();

    IIndexManager indexMgr = CCorePlugin.getIndexManager();
    ICProject cProject = CoreModel.getDefault().getCModel().getCProject(bareProject.getName() );
    indexMgr.setIndexerId(cProject, IPDOMManager.ID_FAST_INDEXER);

    CoreModel.getDefault().setProjectDescription(bareProject, cDescription);

    ManagedBuildManager.setDefaultConfiguration(bareProject, config );
    ManagedBuildManager.setSelectedConfiguration(bareProject, config );

    ManagedBuildManager.setNewProjectVersion(bareProject);

    ManagedBuildManager.saveBuildInfo(bareProject, true);

    return bareProject;

}