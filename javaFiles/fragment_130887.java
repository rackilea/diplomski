import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MongoImportUtil {

    public static void main(String[] args) {

        String db = "test";
        String col = "Account";
        String Host = "localhost";
        String Port = "27017";
        String fileName = "D:/files/sample.csv";

        String command = "C:\\Program Files\\MongoDB\\Server\\3.4\\bin\\mongoimport.exe --host " + Host + " --port "
                + Port + " --db " + db + " --collection " + col + " --headerline --type=csv --file " + fileName;

        try {
            System.out.println(command);

            Process process = Runtime.getRuntime().exec(command);
            int waitFor = process.waitFor();
            System.out.println("waitFor:: " + waitFor);
            BufferedReader success = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String s = "";
            while ((s = success.readLine()) != null) {
                System.out.println(s);
            }

            while ((s = error.readLine()) != null) {
                System.out.println("Std ERROR : " + s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}