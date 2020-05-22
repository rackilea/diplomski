public synchronized static WebService getInstance()
    {
        if(instance == null)
            instance = new WebService();
        return instance;
    }