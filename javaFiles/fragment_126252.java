import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GasPrices {

    public static void main(String[] args) throws IOException
    {
        String fileName = "1994_weekly_gas_averages.txt";

        ArrayList<Double> gas = new ArrayList<>();

        try  
        {
            FileReader reader = new FileReader(fileName);
            BufferedReader bReader = new BufferedReader(reader);
            String line;

            while ((line = bReader.readLine()) !=null)
            {
                String g = String.valueOf(line);
                String dateStr = g.substring(0, 12);
                String doubleStr = g.substring(16);
                System.out.println("dateStr>>"+dateStr);
                System.out.println("doubleStr>>"+doubleStr);
                gas.add(Double.valueOf(doubleStr));
                System.out.println();


//                gas.add(Double.parseDouble(g));
//                System.out.println(gas);
             }
            System.out.println("gas.size()>>"+gas.size());
         } catch (IOException e)
        {
            System.out.println("Exception: " + e);
        }
    }
}