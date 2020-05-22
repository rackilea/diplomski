@ManagedBean
@RequestScoped
public class Bean {

    private String result;

    public void hey() {
        result = "Hello World!";
    }

    public String getResult() {
        return result;
    }

}