public static void main(String[] args) {
     Injector injector = Guice.createInjector(new UtilModule(), new BusinessModule());
     BusinessService businessService = injector.getInstance(BusinessService.class);
     ...

}