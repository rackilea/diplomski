@Configuration
@DependsOn("mongoTemplate")
public class MongoCollectionConfiguration {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public MongoCollectionConfiguration(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @PostConstruct
    public void initIndexes() {
        mongoTemplate.indexOps("collection_1")
            .ensureIndex(
                new Index().on("location.timestamp", Sort.Direction.DESC).expire(604800)
            );
        mongoTemplate.indexOps("collection_2")
            .ensureIndex(
                new Index().on("location.timestamp", Sort.Direction.DESC).unique()
            );    
    }