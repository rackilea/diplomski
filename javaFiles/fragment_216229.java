import java.awt.Desktop;
import java.io.File;
public class MyClass {
 public static void main(String[] args) throws IOException {
        File file = new File("myFile.txt");
        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) desktop.open(file);

}
}