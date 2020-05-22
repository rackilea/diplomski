import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(new File("GameDatabase.csv").exists()); // the file does not exist in FinalProject folder
        System.out.println(new File("src/GameDatabase.csv").exists()); // but exists in FinalProject/src
        System.out.println(Main.class.getClassLoader().getResourceAsStream("GameDatabase.csv").toString()); // this is a solution to look for the file within the classpath
    }
}