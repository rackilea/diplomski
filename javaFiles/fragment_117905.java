@RunWith(SpringRunner.class)
@DataMongoTest
@Import(ExtraMongoConfiguration.class) // if you need some @Configuration to be imported
public class SomeRepositoryTests {

    @Autowired
    private MongoTemplate mongoTemplate;

}