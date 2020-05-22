import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

@Singleton
public class SingletonEJB {

    @PostConstruct
    public void oneTimeOnly() {
        System.out.println("one time after every construct");
    }
}