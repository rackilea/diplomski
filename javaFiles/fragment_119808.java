@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles(profiles = { "test" }) // It is recommended to have a test profile for your integration test
public abstract class ParentTest {

}