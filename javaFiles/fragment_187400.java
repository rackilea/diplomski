@SpringBootApplication
public class MyTicketApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(MyTicketApplication.class, args);
    }
}