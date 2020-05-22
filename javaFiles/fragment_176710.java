public static List<IConfiguration> getValidConfigsForPlatform() {
    List<IConfiguration> configurations = 
        new ArrayList<IConfiguration>();

    for (IConfiguration cfg : ManagedBuildManager.getExtensionConfigurations() ) {
        IToolChain currentToolChain =
            cfg.getToolChain();

        if ( (currentToolChain != null )                           && 
             (ManagedBuildManager.isPlatformOk(currentToolChain) ) &&
             (currentToolChain.isSupported() )                     ) {

            configurations.add(cfg);
        }
    }
    return configurations;
}