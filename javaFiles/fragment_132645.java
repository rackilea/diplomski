import org.reflections.Reflections;
import sub.optimal.DummyInterface;
public class Main {
    public static void main(String[] args) throws Exception {
        Reflections reflections = new Reflections("sub.optimal");
        for (Class c : reflections.getSubTypesOf(DummyInterface.class)) {
            System.out.println("class: " + c.getCanonicalName());
            c.newInstance();
        }
   }
}