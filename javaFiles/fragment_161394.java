@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ReportApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MyApplication.class, args);
    }
}