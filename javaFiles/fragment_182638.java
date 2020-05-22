import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Trial {

    public static void main(String[] args) throws IOException {
        String strLine;
        BufferedReader reader = new BufferedReader(new FileReader(
                "/home/user234/folder1/filename"));
        while ((strLine = reader.readLine()) != null) {
            if (!strLine.isEmpty()) {
                System.out.println("notEMPTY");
            } else {
                System.out.println("EMPTY");
            }
        }
    }
}