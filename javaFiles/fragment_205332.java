@SpringBootApplication(scanBasePackages = { "com" })
@EntityScan(basePackages = { "com" })
public class SpringBootAplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootAplication.class, args);
    }

}