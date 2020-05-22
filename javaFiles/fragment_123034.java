import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ReadMyResources {

    public static void main(String[] args) {
        new ReadMyResources();
    }

    public ReadMyResources() {
        JarFile jf = null;
        try {            
            String s = new File(this.getClass().getResource("").getPath()).getParent().replaceAll("(!|file:\\\\)", "");
            jf = new JarFile(s);

            Enumeration<JarEntry> entries = jf.entries();
            while (entries.hasMoreElements()) {
                JarEntry je = entries.nextElement();
                if (je.getName().startsWith("resources")) {
                    System.out.println(je.getName());
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                jf.close();
            } catch (Exception e) {
            }
        }
    }

}