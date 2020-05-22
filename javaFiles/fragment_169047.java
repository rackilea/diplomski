import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample {

    public static void main(String[] sm) {

        BufferedReader br = null;

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader("You file path"));
            String[] xy;
            // get your points and convert very first line
            int points = Integer.parseInt(br.readLine()); 
            while ((sCurrentLine = br.readLine()) != null) {
                xy = sCurrentLine.split("\\s+"); // split by whitespace
                System.out.println(xy[0] +" : "+ xy[1]);
                // Do something
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                                        br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}