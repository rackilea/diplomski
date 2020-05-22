import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;



public class Adding_Deleting_Car{

        public static void main(String... args) throws IOException{
        Scanner in = new Scanner(System.in);
        File inputFile = new File("inventory.txt");
        File tempFile = new File("myTemp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        String lineToRemove;
        System.out.println("Enter the VIN of the car you wish to delete/update: ");
        lineToRemove = in.next();

        while((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            if(trimmedLine.startsWith(lineToRemove)) continue;
            System.out.println(trimmedLine);
            writer.write((currentLine) + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        Files.move(tempFile.toPath(), inputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}