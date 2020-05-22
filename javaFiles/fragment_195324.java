import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class NumberGenerator {
    public static void main(String [] args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("./startreader.sh");
        Process process = processBuilder.start();
        Scanner processStreamReader = new Scanner(process.getInputStream());
        String processInputString = null;
        do {
            try(FileWriter fileWriter = new FileWriter("inputbridge.txt", true)) {
                fileWriter.write(((int)(Math.random() * ((10 - 1) + 1)) + 1) + "\n");
            } catch(IOException e) {
                e.printStackTrace();
            }
            processInputString = processStreamReader.nextLine();
            System.out.println(processInputString);

        } while(processInputString.startsWith("Send me something other than"));
    }
}