@Service("mongoDAO")
public class MongoDAO {


    @Resource
    private DBCollection user ;
    @Resource
    private MongoDatabase userDatabase;
    @Resource
    private MongoCollection<Document> usersCollection;
    @Resource
    private MongoClient mongoClient;

    public MongoDAO() {

    }

    @PostConstruct
    public postConstruct() {
        usersCollection = userDatabase.getCollection("user");

    }