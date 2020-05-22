import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Sample {

    public static void main(String[] args) throws Exception {
        try {
            Process p = Runtime.getRuntime().exec("C:/Windows/py myScript.py");
            String cmdOutput = null;
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            // read the output from the command
            while ((cmdOutput = stdInput.readLine()) != null) {
                System.out.println(cmdOutput);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}