import static java.lang.System.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSWrite1 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(in)) {
            out.print("Enter file name> ");
            String file = input.nextLine();
            try (FileWriter fw = new FileWriter(file)) {
                out.print("Enter text: ");
                String text = input.nextLine(); // IN:"Hello, How are you" --> "Hello,
                fw.write(text);
            }
            catch (IOException xIo) {
                xIo.printStackTrace();
            }
        }
    }
}