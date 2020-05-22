import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class CSV {

    private List<String[]> fileContent;

    public CSV(String filePath) {
        try {
            readCSV(filePath);
        } catch (IOException e) {
            System.out.print("There was an error reading this CSV file. Error follows:");
            e.printStackTrace();
        }
    }

    public void readCSV(String csvPath) throws IOException {
        // Store coupon objects in array list
        CSVReader csvReader = new CSVReader(new FileReader(csvPath));

        // Store each row into a String list
        List<String[]> csvData = csvReader.readAll();

        csvReader.close();
        fileContent = csvData;
    }

    public void printFileContent() {
        System.out.println("");
        for (String[] row : fileContent.subList(1, fileContent.size())) {

            for (String s: row) {

                 System.out.print(s + " ");

             }

            System.out.println();
        }
        System.out.println("");
    }
}