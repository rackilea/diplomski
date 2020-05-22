import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ApacheTopCall{

        public static void main(String args[]) {

                String fileName = "apache_logs_index";
                String command = "apachetop";
                command = command + " -d 1 -q -l -r -p"; //extra params
                try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

                        String line;
                        while ((line = br.readLine()) != null) {
                                command = command + " -f " + line.trim();
                        }
                        System.out.println(command); //we are just creating the command for run. The C program actually run the generated command.
                        //ProcessBuilder pb = new ProcessBuilder("/bin/bash", "-c", command);
                        //Process p = pb.start();
                        //p.waitFor();
                } catch (IOException e) {
                        e.printStackTrace();
                }

        }

}