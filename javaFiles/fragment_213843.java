@SpringBootApplication
@EnableJpaRepositories // just to make sure
public class HibernateProxyDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(HibernateProxyDemoApplication.class, args);
    }
...
}