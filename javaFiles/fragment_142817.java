import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class aScanner {

    static String usernameMac = System.getProperty("user.name");
    final static File foldersMac = new File("/Users/" + usernameMac + "/Library/Mail/V2");

    public static void main(String[] args) throws IOException {
        listFilesForFolder(foldersMac);
    }

    public static void listFilesForFolder(final File foldersMac) throws IOException {
        for (final File fileEntry : foldersMac.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                ArrayList<String> lines = new ArrayList<>();
                try (BufferedReader bReaderM = new BufferedReader(new FileReader(fileEntry))) {
                    String lineMe;
                    while ((lineMe = bReaderM.readLine()) != null) {
                        if (lineMe.contains(".com")) {
                            lines.add(lineMe);
                        }
                    }
                }
                if (!lines.isEmpty()) {
                    System.out.println(fileEntry.getAbsolutePath() + ":");
                    for (String line : lines) {
                        System.out.println("  " + line.trim());
                    }
                }
            }
        }
    }
}