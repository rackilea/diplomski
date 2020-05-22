import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SalesAnalysis
{
    public static void main (String[] args) throws FileNotFoundException
    {

        Scanner salesDataFile = new Scanner(new File("SalesData.txt"));

        ArrayList<Double> salesData = new ArrayList<Double>();

        while(salesDataFile.hasNextLine()){
            String line = salesDataFile.nextLine();

            Scanner scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while(scanner.hasNextDouble()){
                salesData.add(scanner.nextDouble());
            }
            scanner.close();
        }

        salesDataFile.close();

        System.out.println(salesData);
    }
}