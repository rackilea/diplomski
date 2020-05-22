public static class AppConfig extends DefaultResourceConfig {
    public AppConfig() {

        MyService myService = new MyService();
        MyDAO myDAO = mock(MyDAO.class);
        myService.setMyDAO(myDAO);

        getSingletons().add(new ExceptionMapperProvider()); 
        getSingletons().add(myService);
    }
}