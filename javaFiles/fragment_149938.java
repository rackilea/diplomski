public class DatabaseServiceImplTestConfig {

   @Bean
   public DatabaseService databaseService() {
    return new DatabaseServiceImpl();
   }
}