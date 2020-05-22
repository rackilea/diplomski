import java.util.Arrays;

public class JavaSide {
    public static void doSmth(Object arr) {
        byte[] b = (byte[]) arr;
        System.out.println(Arrays.toString(b));
    }
}