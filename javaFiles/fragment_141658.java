@RunWith(SpringRunner.class)
@ContextConfiguration(initializers = ConfigFileApplicationContextInitializer.class)
public class ValueAnnotationTest {

    @Value("${myUrl}")
    private String myUrl;

    @Test
    public void test1() throws Exception {
    assertThat(myUrl).isEqualTo("http://test.com");
    }
}