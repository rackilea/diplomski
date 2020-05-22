import java.io.File;

public class PathTest {

    public static void main(String[] args) throws Exception {
        File file = new File("DoesNotExist.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());
    }
}