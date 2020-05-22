@SpringBootApplication(scanBasePackages {"com.jsp.models","com.jsp.repositories","com.jsp.services"})
@RestController    --> THIS CAN BE REMOVED
public class Server {
   public static void main(String[] args) {
       SpringApplication.run(Server.class, args);
   }
}