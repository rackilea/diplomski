private GeofenceRepository(MtsAPI mtsAPI, UserLoginDetailsDao dao, Application 
context) {
        this.mtsAPI = mtsAPI;
        this.dao = dao;
        this.context = context;
        MtsApiInterface mtsApiInterface = 
        RetrofitInstance.getRetrofitInstance().create(MtsApiInterface.class);
        AppDatabase db = AppDatabase.getInMemoryDatabase(context);
        dao = db.userLoginDetailsDao();
    }
}