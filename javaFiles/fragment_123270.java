@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Profile("test")
public class CachingConfigTest {

    @Autowired
    private CachingConfig cachingConfig;

    @Test
    public void test() {
        System.out.println(cachingConfig.getSpecs());
     }

 }