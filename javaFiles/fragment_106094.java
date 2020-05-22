// Import only this RequestScoped
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class Temp {

    public Temp() { }

    public String getMe() {
        return "something";
    }
}