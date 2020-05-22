private AppSingleton() {
        super();
        appInstance = new AppSingleton();
    }

    public static  AppSingleton getAppInstance() {
        if (appInstance == null) {
            appInstance = new AppSingleton();
        }
        return appInstance;
    }