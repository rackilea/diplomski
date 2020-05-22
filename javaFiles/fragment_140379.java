protected IResourceInfo getResourceInfo(ITranslationUnit translationUnit, ICProjectDescription prjDescription) {

    ICProject cProject = translationUnit.getCProject();
    if (cProject != null) {
        ICConfigurationDescription cfgDescription = prjDescription.getActiveConfiguration();
        IConfiguration configuration = ManagedBuildManager.getConfigurationForDescription(cfgDescription);
        IPath projectPath = translationUnit.getResource().getProjectRelativePath(); 
        IResourceInfo ri = configuration.getResourceInfo(projectPath, true);

        if (ri == null) { 
            ri = configuration.createFileInfo(projectPath);
        }

        return ri;
    }

    return null;
}