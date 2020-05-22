@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("test")
@WebAppConfiguration
/**
 * If you have any property file to load to test uncomment below line) 
   @TestPropertySource({
   "classpath:/properties/dbConfig-test.properties",
   "classpath:/properties/unittest.properties"
   })
*/
public abstract class AbstractSpringTest{}