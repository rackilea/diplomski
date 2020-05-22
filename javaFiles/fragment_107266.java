@Provides
MyApp externalService(DatabaseClient dbClient, Whistlefeather wf) {
    MyApp app = new MyApp();
    app.setDatabaseCLient(dbClient);
    app.setWhitlefeature(wf);
    return app;
}