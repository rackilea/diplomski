@Configuration
@EnableJpaStores
@Import("org.springframework.content.rest.config.RestConfiguration.class") <!-- enables REST API)
public class ContentConfig {

   <!-- specify the resource specific to your database --> 
   @Value("/org/springframework/content/jpa/schema-drop-h2.sql")
   private ClasspathResource dropBlobTables;

   <!-- specify the resource specific to your database --> 
   @Value("/org/springframework/content/jpa/schema-h2.sql")
   private ClasspathResource createBlobTables;

   @Bean
   DataSourceInitializer datasourceInitializer() {
     ResourceDatabasePopulator databasePopulator =
            new ResourceDatabasePopulator();

     databasePopulator.addScript(dropBlobTables);
     databasePopulator.addScript(createBlobTables);
     databasePopulator.setIgnoreFailedDrops(true);

     DataSourceInitializer initializer = new DataSourceInitializer();
     initializer.setDataSource(dataSource());
     initializer.setDatabasePopulator(databasePopulator);

     return initializer;
   }
}