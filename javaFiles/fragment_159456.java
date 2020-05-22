@RunWith(Arquillian.class)
public class Test {

    @Deployment(testable = false)
    public static Archive<?> createDeployment() {
        // ...
    }

    @Test
    public void test() {
        // ...
    }

}