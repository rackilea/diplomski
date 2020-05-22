import java.util.*;
import java.lang.annotation.*;

@Retention(value=RetentionPolicy.RUNTIME)
@interface SomeName {
    String name();
}

@SomeName(name = "ABC")
interface Bank {

}

class BankImpl implements Bank {
}

public class Test {
    public void someMethod(Class c) {
        Annotation annotation = c.getAnnotation(SomeName.class);

        if (annotation == null) {
            LinkedList<Class> queue = new LinkedList<Class>();
            queue.addLast(c.getSuperclass());

            for (Class cc : c.getInterfaces())
                queue.addLast(cc);

            while (!queue.isEmpty()) {
                c = queue.removeFirst();
                annotation = c.getAnnotation(SomeName.class);

                if (annotation != null)
                    break;              
            }
        }

        if (annotation == null)
            System.out.println("No such annotation !");
        else
            System.out.println("name is: " + ((SomeName)annotation).name());
    }

    public static void main(String... args) {
        Test test = new Test();
        test.someMethod(BankImpl.class);
    }
}