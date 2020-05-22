if (instance == null) {
        instance = new LoadingThread();
        instance.loadingActivity = loadingActivity;

    }
    return instance;