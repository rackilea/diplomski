import java.util.logging.Logger;

public class Example {

    private static final Logger log = Logger.getLogger(Example.class.getName());

    static void doStuff(int[] pBuffer) {
        int tmp = pBuffer[5] + 4;
        log.info("tmp:" + tmp);
    }

    public static void main(String[] args) {
        doStuff(new int[] {0, 1, 2, 3, 4, 5});
    }
}