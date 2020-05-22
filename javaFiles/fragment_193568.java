import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVReader;

public class CsvFileReader {
    public static void main(String[] args) {

        try {
            System.out.println("\n**** readLineByLineExample ****");
            String csvFilename = "C:/Users/hussain.a/Desktop/sample.csv";
            CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
            String[] col = null;
            while ((col = csvReader.readNext()) != null) 
            {
                System.out.println(col[0] );
                //System.out.println(col[0]);
            }
            csvReader.close();
        }
        catch(ArrayIndexOutOfBoundsException ae)
        {
            System.out.println(ae+" : error here");
        }catch (FileNotFoundException e) 
        {
            System.out.println("asd");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("");
            e.printStackTrace();
        }
    }
}