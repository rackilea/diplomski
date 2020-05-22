import java.io.*;

public class RubyCall {
    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("ruby script.rb");
            process.waitFor();

            BufferedReader processIn = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = processIn.readLine()) != null) {
                System.out.println(line);
            } 
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}