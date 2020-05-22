@Stateless
@Remote(TestServiceRemote.class)  
public class TestService implements TestServiceRemote {

    public TestService() {  }

    public void sayRemote() {
        System.out.println("\n\nHello");
    }
}