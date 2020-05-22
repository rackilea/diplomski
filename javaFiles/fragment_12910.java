@SpringBootApplication
@Configuration  
@Import({JerseyConfig.class})
public class UserServiceApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(UserServiceApplication.class)
                .run(args);
    }    
}