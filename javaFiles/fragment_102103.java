@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT  , properties = {
        "management.server.port=0", "management.context-path=/admin" ,"security.basic.enabled=false"} )
@ContextConfiguration( classes = {AllowAnonymousWebAccess.class  } )
@AutoConfigureMockMvc // i do not why you use it ?
@DataJpaTest
@TestPropertySource(locations = "classpath:application-testing-h2.properties")
@EntityScan(basePackages = {"fullPackage.entity")
@EnableJpaRepositories(
    basePackages = {"fullPackage.repository"}
public class SchedulerJobTestInt {
...
}