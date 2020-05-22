@RunWith(Arquillian.class)
public class Test {

    @Deployment
    public static Archive<?> createDeployment() {
        // ...
    }

    @Test
    @RunAsClient
    public void test() {
        // ...
    }

}