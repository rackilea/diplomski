public ResourceMap getResourceMap() {
    if (resourceMap == null) {
        ApplicationContext context = getContext();
        if (context != null) {
            resourceMap = context.getResourceMap(getResourceStartClass(), 
                   getResourceStopClass());
        }
    }

    return resourceMap;
}

public ApplicationContext getContext() {
    if (applicationContext == null) {
        Application app = getApplication();
        if (app != null) {
            applicationContext = app.getContext();
        }
    }

    return applicationContext;
}

public Application getApplication() {
    if (application == null) {
        application = Application.getInstance();
    }

    return application;
}