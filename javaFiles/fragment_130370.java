@EnableWebMvc
@Configuration
@Import({Swagger2DocumentationConfiguration.class})
//@ComponentScan(basePackages = {"springfoxswagger.specialpackageswagger"})
public class ApplicationSwaggerConfig {

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("rest-api")
                .select()
                .build()
                .pathMapping("/rest-api");
    }


    @Bean
    public springfox.documentation.swagger2.mappers.ServiceModelToSwagger2Mapper mapper() {
        return new  ServiceModelToSwagger2MapperImpl() {
            public Swagger mapDocumentation(Documentation from) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n******************** Override works!!!\n");
                return super.mapDocumentation(from);
            }

        };
    }

}