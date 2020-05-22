package example;

import java.io.FileWriter;
import java.io.IOException;

import org.supercsv.io.CsvListWriter;
import org.supercsv.io.ICsvListWriter;
import org.supercsv.prefs.CsvPreference;

public class ColumnFirst {

    public static void main(String[] args) {

        // you can assemble this 2D array however you want
        final String[][] csvMatrix = new String[3][3];
        csvMatrix[0][0] = "first0";
        csvMatrix[0][1] = "second0";
        csvMatrix[0][2] = "third0";
        csvMatrix[1][0] = "first1";
        csvMatrix[1][1] = "second1";
        csvMatrix[1][2] = "third1";
        csvMatrix[2][0] = "first2";
        csvMatrix[2][1] = "second2";
        csvMatrix[2][2] = "third2";

        writeCsv(csvMatrix);

    }

    private static void writeCsv(String[][] csvMatrix) {

        ICsvListWriter csvWriter = null;
        try {
            csvWriter = new CsvListWriter(new FileWriter("out.csv"), 
                CsvPreference.STANDARD_PREFERENCE);

            for (int i = 0; i < csvMatrix.length; i++) {
                csvWriter.write(csvMatrix[i]);
            }

        } catch (IOException e) {
            e.printStackTrace(); // TODO handle exception properly
        } finally {
            try {
                csvWriter.close();
            } catch (IOException e) {
            }
        }

    }

}