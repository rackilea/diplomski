package your.package.name;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class CSVReader {
    public static void main(String[] args) {
        String csvFile = "yourfilepath/abc.csv";
        String line = "";
        String cvsSplitBy = ",";
        String strIPs = "";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] val = line.split(cvsSplitBy);
             if(val[1] == "6/24/2019") strIPs += val[0] + ",";
            }
                System.out.println("strIPs ="+strIPs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}