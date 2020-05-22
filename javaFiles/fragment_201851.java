import java.util.concurrent.Callable;
public class Clazz {

    public static void main(String[] args) throws Exception {
        new Clazz().method();
    }

    public void method() throws Exception {
        Clazz.staticMethod(() -> {
            Integer x = 1;
            Long y = 2L;
            y = x * y; // I need a Break point here
            return y;
        });
    }

    private static void staticMethod(Callable i) throws Exception {
        System.out.println("i = " + i.call());
    }
}