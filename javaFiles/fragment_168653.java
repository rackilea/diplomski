import sun.misc.Unsafe;
import java.lang.reflect.Field;

public class Crash extends Thread {
    static volatile Object obj = 0;

    public static void main(String[] args) throws Exception {
        new Crash().start();

        // Give some time to compile run() method
        Thread.sleep(2000);

        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);

        // Overwrite Object's class field, so that 'instanceof' cannot work
        unsafe.putInt(obj, 8L, -1);
    }

    public void run() {
        while (!(obj instanceof Runnable)) {
            // Loop until crash
        }
    }
}