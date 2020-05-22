`
import java.io.*;

public class FileUtil {

public File generateFile() {
    File sampleFile = new File("./sampleFile.txt");
    try {
        FileOutputStream is = new FileOutputStream(sampleFile);
        OutputStreamWriter osw = new OutputStreamWriter(is);
        Writer w = new BufferedWriter(osw);
        w.write("sample file text");
        w.write("testing new line");
        w.close();
    } catch (IOException e) {
        System.err.println("Problem writing to the file sampleFile.txt");
    }

    String line = null;

    try {
        FileReader fileReader = new FileReader(sampleFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        // do not close fileReader
        // leave it open so that we can delete the file and still return it
    } catch (FileNotFoundException ex) {
        System.out.println("Unable to open file");
    } catch (IOException ex) {
        System.out.println("Error reading file");
    }

    sampleFile.delete();

    return sampleFile.getAbsoluteFile();
}

public static void main(String[]args) {
    FileUtil myFile = new FileUtil();
    myFile.generateFile();
}
}`