import java.util.Vector;

public class memtest {

    public static void main(String args[]) throws Exception {
        Vector<byte[]> v = new Vector<byte[]>();
        while (true) {
            v.add(new byte[128 * 1024]);
            System.out.println(v.size());
        }

    }
};