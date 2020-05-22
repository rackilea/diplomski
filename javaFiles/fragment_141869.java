@SpringBootApplication(scanBasePackages {"com.jsp.models","com.jsp.repositories","com.jsp.services"})
 @EnableJpaRepositories("com.jsp.repositories")
 public class Server {
    public static void main(String[] args) {
       SpringApplication.run(Server.class, args);
    }
 }