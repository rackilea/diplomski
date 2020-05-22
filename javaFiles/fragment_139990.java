private AppSingleton() {
        super();
        appInstance = this; // keep ref to this application instance
    }

    public static  AppSingleton getAppInstance() {
        return appInstance;
    }