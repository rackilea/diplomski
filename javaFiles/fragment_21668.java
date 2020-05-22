@Configuration
@ComponentScan({ "com.project.dao"})
public class TestConfiguration {

    @Bean
    public GenericDao getGenericDao() {
         return new MockGenericDaoImpl();
    }
}