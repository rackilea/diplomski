@Configuration
public class DaoConfiguration {

    private SessionFactory sf;

    @Bean
    public GenericDao<Employee, Integer> employeeDao() {
         return new GenericDaoImpl<Employee, Integer>(Employee.class, sessionFactory);
    }

    // Other daos
}