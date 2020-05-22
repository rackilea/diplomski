//main class
import java.io.IOException;
import java.util.List;

public class Prueba {

    public static void main(String[] args) throws IOException {

        String filePath = "E:/Temp/in.txt";

        try {
            ReadFile rF = new ReadFile(filePath);
            List<String> receivedArray = rF.read();

            for (String currentLine : receivedArray) {
                System.out.println(currentLine);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

//class called from main class

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    private final String path;

    public ReadFile(String path) {
        this.path = path;
    }

    public List<String> read() throws IOException {
        // Create an empty List to protect against NPE
        List<String> textData = new ArrayList<String>();

        FileReader fR = null;
        BufferedReader bR = null;

        try {
            fR = new FileReader(path);
            bR = new BufferedReader(fR);

            String line;

            while ((line = bR.readLine()) != null) {
                textData.add(line);
            }
        } catch (IOException e) {
            throw e;
        } finally {
            // Close all the open resources
            bR.close();
            fR.close();
        }

        return textData;
    }
}