import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
    public static void main(final String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("ac.xml");
        try {
            Thread.sleep(1000 * 60 * 5);
        } catch (final Throwable t) {}
    }
}