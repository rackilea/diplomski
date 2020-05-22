import test.A;
import test.B;

@RunWith(SpringRunner.class)
public class MyTest {

    @Configuration
    @ComponentScan("test")
    static class Config {}

    @Autowired
    private A a;

    @Autowired
    private B b;

    @Test
    public void test() {
        a.getStringValue();
    }
}