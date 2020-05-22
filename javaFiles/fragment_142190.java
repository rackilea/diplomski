@Configuration
@EnableAutoConfiguration
@ComponentScan("com.mytest")
public class WebApplicationStarter extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplicationStarter.class);
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(WebApplicationStarter.class, args);
    }

    @Bean
    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
        return hemf.getSessionFactory();
    }
}