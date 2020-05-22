import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class Test006 {

    public static void main(String[] args) throws Exception {
        byte[] bytes = new byte[] { -1, 1, 0x0 }; 
        InputStream in = new ByteArrayInputStream(bytes);
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
    }

}