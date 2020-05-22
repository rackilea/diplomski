public static AppModuleImpl getApp() {
    return (AppModuleImpl)Configuration.
            createRootApplicationModule(
            "com.test.service.AppModule", // where your module is stored
            "AppModuleShared"); // chosen configuration
}