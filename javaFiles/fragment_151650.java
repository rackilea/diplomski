import java.io.*;

public class FileReadWrite {

public static void main(String[] args) {
    try {
        FileReader inputFileReader = new FileReader(new File("E:/split/11072014/01434.RPT"));
        FileWriter outputFileWriter = new FileWriter(new File("E:/split/11072014/Berhasil.RPT"));
        BufferedReader bufferedReader = new BufferedReader(inputFileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(outputFileWriter);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            for (String splitItem : line.split("|")) {
                bufferedWriter.write(splitItem + "\n");
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}