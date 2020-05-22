@SpringBootApplication
@ComponentScan(basePackages = { "test" })
@EnableSwagger2
public class Application {

  @Bean
  public Docket confApi() {
    ResponseMessage msg_500 = new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("Error")).build();
    return new Docket(DocumentationType.SWAGGER_2).globalResponseMessage(RequestMethod.GET, Collections.singletonList(msg_500))
        .globalResponseMessage(RequestMethod.POST, Collections.singletonList(msg_500))
        .apiInfo(new ApiInfo("My Api Documentation", "My Api Documentation, Version: 1.0", "1.0", null, "my_name@gmail.com", null, null));
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}