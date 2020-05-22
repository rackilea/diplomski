@Configuration
@DependsOn("mongoTemplate")
public class CollectionsConfig {

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    public void initIndexes() {
        mongoTemplate.indexOps("collectionName") // collection name string or .class
            .ensureIndex(
                new Index().on("name", Sort.Direction.ASC)
        );
    }
}