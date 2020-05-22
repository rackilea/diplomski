import com.sun.jna.Library;
import com.sun.jna.Native;

public class Main {
    public interface Ihello extends Library {
        public String hello(String hey);
    }

    public static void main(String args[]) {
        //"hello-world is the name my DLL, for example.
        Hello h = Native.load("hello-world", Hello.class);

        System.out.println(h.hello(" John! ");
    }
}