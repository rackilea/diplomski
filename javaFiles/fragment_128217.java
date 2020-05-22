import java.io.File;

public class Test {

    public static void main(String[] args) {
        File file = new File("\\\\server01\\\\folder");
        System.out.println(file.isDirectory());
        System.out.println(file.exists());

    }
}