import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static void main(String[] args) {

        String csvFile = "E:\\country.csv";
        String line = "";
        String cvsSplitBy = ",";
        List<String> sub = new ArrayList<String>();
        List<List<String>> master = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                sub = new ArrayList<String>();
                sub.add(line);
                master.add(new ArrayList<String>(sub));
//              System.out.println(sub);
                sub.remove(0);

//                System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(master);

    }

}