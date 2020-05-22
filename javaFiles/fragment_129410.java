@EnableAutoConfiguration
public class SpringTestConfig {

     // Set up whatever you need

     @Bean
     @Autowired
     MyAggregateDao myDao (DataSource dataSource) {

         // ...
     }


     @Bean
     @Autowired
     EventStorageEngine eventStorageEngine () {

         return new InMemoryEventStorageEngine();

     }

}