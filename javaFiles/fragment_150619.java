import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) {
        try {
            Process proc = Runtime.getRuntime().exec("cmd set PATH=%PATH%;C:\\Something\\bin");
            proc.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

            String line = reader.readLine();
            while (line != null) {
                //Handle what you want it to do here
                line = reader.readLine();
            }
        } 
        catch (IOException e1) { 
            //Handle your exception here
        }
        catch(InterruptedException e2) {
            //Handle your exception here
        }

        System.out.println("Path has been changed");
    }
}