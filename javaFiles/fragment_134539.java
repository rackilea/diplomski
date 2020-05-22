@SpringBootApplication
@EnableElasticsearchRepositories
public class SpringdataElasticTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdataElasticTestApplication.class, args);
    }

    @Bean
    RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration configuration = ClientConfiguration.localhost();
        RestHighLevelClient client = RestClients.create(configuration).rest();
        return client;
    }

    @Bean
    ElasticsearchRestTemplate elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(elasticsearchClient());
    }
}