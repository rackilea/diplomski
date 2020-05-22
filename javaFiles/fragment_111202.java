@Named
@ViewScoped
@Logging(Level.DEBUG)
public class SimpleBean {

    public void methodA() {
        methodB();
    }

    public void methodB() {
        // do something
    }
}