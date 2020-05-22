import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileChooser {

    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter(chooseFile());
        // Use your FileWriter
    }

    public static File chooseFile() {
        String fname = null;
        File file = null;

        System.out.println("Please choose file name:");
        while (true) {
            try (Scanner in = new Scanner(System.in)) {
                // Reads a single line from the console
                fname = in.nextLine();
                file = new File(fname);
                if (!file.createNewFile()) {
                    throw new RuntimeException("File already exist");
                }
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage() + ", please try again:");
            }
        }

        return file;
    }
}