@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestPropertySource(value = "classpath:testApplication.properties")
public class ESJavaAPITests {

    @Value("${ES.cluster.name}")
    private String CLUSTER_NAME;
}