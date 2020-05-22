import java.io.File;
import java.util.Scanner;

public class Sample {

    public static void main(String[] args) throws Exception {
        String fileName = "src/main/resources/input-01.txt";
        readInput(fileName);
    }

    public static void readInput(String fileName) throws Exception {
        File file = new File(fileName);
        Scanner fileInput = new Scanner(file);
        //Read T
        int var = fileInput.nextInt();
        System.out.println("var = " + var);
    }
}