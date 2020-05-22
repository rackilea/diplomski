@Configuration
  protected class MyRepositoryRestConfigurer implements RepositoryRestConfigurer {

   @Override
   public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
     config.exposeIdsFor(ThemeMessage.class);
   }
}