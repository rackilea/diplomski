import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class JavaApplication28 {

    public static void main(String[] args) throws IOException {
        String input = fruitNameField.getText();
        String filename = "temp.csv";

        writeToCsvFile(input,filename);
    }

    private static void writeToCsvFile(String input, String filename) throws IOException {
        if(!isDuplicate(input,filename)){
            CSVWriter writer = new CSVWriter(new FileWriter(filename,true), ',');
            String[] entries = {fruitNameField.getText(),quantityOfFruitField.getText(),fruitLocationField.getText()};
            writer.writeNext(entries);
            writer.close();
        }
        else{
            System.out.println("fruitName already exists.");
        }        
    }

    private static boolean isDuplicate(String input, String filename) throws IOException  {
        boolean found = false;
        CSVReader reader = new CSVReader(new FileReader(filename));
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
           for(int i = 0; i<nextLine.length; i++){
               if(nextLine[i].equalsIgnoreCase(input)){
                   found = true;
                   break;
               }
           }           
        }
        return found;
    }    
}