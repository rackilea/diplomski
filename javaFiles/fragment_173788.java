@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class) // not needed in later spring version
class MyApplication {
   public static void main(String[] args) {
      SpringApplication.run(MyApplication.class, args);
   }
}