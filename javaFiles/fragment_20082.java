import java.io.File;

import static org.joox.JOOX.$;

public class JooxDemo {

    public static void main(String[] args) throws Exception {
        final File dirWithXmls = new File("xmls");

        for (File xmlFile : dirWithXmls.listFiles()) {

            final String message = $(xmlFile).xpath("//header[type='1']/../message").text();

            System.out.println(xmlFile.getName() + ", message: " + message);
        }
    }
}