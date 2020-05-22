import java.io.*;

public class tmp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        String line;

        while((line = br.readLine()) != null) {
            // do basic string comparisons here
            if(line.equals("...")) {
                // do something
            }
            else if(line.contains(":")) {
                // most likely of type A:100, B:50
            }
            else if(line.equals("End")) {
                // do something
            }
            else {
                // anything else
            }
        }
        br.close();
    }
}