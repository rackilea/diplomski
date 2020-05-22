@Configuration
@ComponentScan(basePackages = {"com.argus.intenew"})  
public class Webconfig  {
    //snip...
    @Bean
    public UserDaoImpl userDao() {
        UserDaoImpl userDao=new UserDaoImpl();
        userDao.setSessionFactory(sessionFactory().getObject());
        return userDao;
    }
}