@Configuration
public class MongoDBConfig {

    @Autowired
    private MongoProperties mongoProperties;

    @Autowired
    private MongoClient mongoClient;


    @Bean
    public MongoTemplate mongoTemplate() {

        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, mongoProperties.getDatabase());
        MappingMongoConverter mongoMapping = (MappingMongoConverter) mongoTemplate.getConverter();
        mongoMapping.setCustomConversions(customConversions()); // tell mongodb to use the custom converters
        mongoMapping.afterPropertiesSet();
        return mongoTemplate;

    }


    public MongoCustomConversions customConversions() {
        return new MongoCustomConversions(Collections.singletonList(new GenderConverter()));
    }
}