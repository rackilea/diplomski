import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class footfall {
    public static void main(String[] args) throws IOException {

        ArrayList<String> list = new ArrayList<>();

        // New BufferedReader.
        BufferedReader reader = new BufferedReader(new FileReader(
                "C:\\idafootfall.csv"));

        // Add all lines from file to ArrayList.
        String line;
        while ((line=reader.readLine())!=null)
            list.add(line);

        // Close it.
        reader.close();

        BufferedReader reader2 = new BufferedReader(new FileReader(
                "C:\\category.csv"));

        // Add all lines from file to ArrayList.
        Map<String,Category> map=new HashMap<String, Category>();
        String line2;
        while ((line2=reader2.readLine())!=null){
            String[] split=line2.split(",");
                try
                {
                  map.put(split[0], new                         Category(Double.valueOf(split[1]),Double.valueOf(split[2])));
               }
               catch(NumberFormatException e)
               {
               }

        }

        // Close it.
        reader2.close();

        // Print size of ArrayList.
        System.out.println("Lines: " + list.size());

        // Print each line.
        int size = list.size();
        int previousHour=0;
        List<String> elements = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            try
            {
            String[] data = (list.get(i)).split(",");
            System.out.println(data[2]);


            double newHourSum = Integer.parseInt(data[2]) - previousHour;
            double footfallHour = ( Integer.parseInt(data[2])/(newHourSum-previousHour)) * map.get(data[0]).foreigners;

            previousHour=Integer.parseInt(data[2]);
            // i want to store every nth row from column 3 as an element
          } catch(NumberFormatException e){}
        }
    }
}

class Category{
    Double foreigners;
    Double locals;

    public Category(Double foreigners,Double locals){
        this.foreigners=foreigners;
        this.locals=locals;
    }
}