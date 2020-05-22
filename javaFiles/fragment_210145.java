@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations="classpath:application-test.properties")
@ContextConfiguration(classes = {WebTests.ConfigurationClass.class, WebTests.ClassToTest.class})
public class WebTests {

}