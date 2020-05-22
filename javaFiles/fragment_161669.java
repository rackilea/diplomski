@SpringBootApplication
public class ApplicationBootConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBootConfiguration.class, args);
    }

    @Bean
    GraphQLSchema schema() {
        return GraphQLSchema.newSchema()
            .query(GraphQLObjectType.newObject()
                .name("query")
                .field(field -> field
                    .name("test")
                    .type(Scalars.GraphQLString)
                    .dataFetcher(environment -> "response")
                )
                .build())
            .build();
    }
}