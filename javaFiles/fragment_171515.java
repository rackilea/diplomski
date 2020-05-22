import java.io.File;

public class Example {
    public static void main(String[] args) {

        File file = new File("C://aa.db");
        File tmpFile = new File("C://temp", file.getName());

        if(file.renameTo(tmpFile)) {
            if(tmpFile.delete()) {
                System.out.println(tmpFile.getName() + " was deleted!");
            } else {
                System.out.println("Delete operation failed.");
            }
        }
    }
}