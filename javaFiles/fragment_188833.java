$ cat src/PrintVersion.java 
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author peter.lawrey
 */
public class PrintVersion {
    public static void main(String... args) throws IOException {
        InputStream is = PrintVersion.class.getClassLoader().getResourceAsStream("res/version.num");
        String version = asString(is);
        System.out.println("Version: "+version);
    }

    public static String asString(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        for(int len; (len = is.read(bytes))>0;)
            baos.write(bytes, 0, len);
        return baos.toString();
    }
}
$ cat src/res/version.num 
version 1.0
$ javac src/PrintVersion.java
$ ls src
PrintVersion.class  PrintVersion.java  res
$ java -cp src PrintVersion
Version: version 1.0