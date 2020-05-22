import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadConsoleScanner {
    public static void main(String[] args) {
        boolean stop = false;
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String sWhatever = "";
        try {
            while(!(stop = (sWhatever = bufferRead.readLine()).matches(""))){
                if (!stop) System.out.println(sWhatever);
            }
            System.out.println("done");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}