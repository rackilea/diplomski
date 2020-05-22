@Autowired // for AWS
private static ApplicationContext context;
// I believe this only runs during an embedded Tomcat with `mvn spring-boot:run`. 
// I don't believe it runs when deploying to Tomcat on AWS.
public static void main(String[] args) {
    context = SpringApplication.run(MyApplication.class, args);