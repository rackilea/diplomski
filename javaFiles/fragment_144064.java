package resourcestest;

import java.io.File;
import java.io.FileReader;
import java.net.URL;

public class Test {

    public static void main(String[] args) throws Exception {

        final URL test = Test.class.getResource("/");
        System.out.println(test);

        final URL url = Test.class.getResource("/resources/test.txt");
        System.out.println(url);

        if(url == null) {
            System.out.println("URL is null");
        } else {
            final File file = new File(url.toURI());
            final FileReader reader = new FileReader(file);
            final char[] buff = new char[20];
            final int l = reader.read(buff);
            System.out.println(new String(buff, 0, l));
            reader.close();
        }

    }

}