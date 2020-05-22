import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class cars
{

    public static void main(String[] args)
    {
        Scanner x = null;
        try
        {
            x = new Scanner(new File("cars.txt"));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        ArrayList<String[]> arr = new ArrayList<String[]>();
        while (x.hasNext())
        {
            String str[] = x.next().split("~");
            arr.add(str);
        }

        for (String[] car : arr)
        {
            if (car[0].equals("Toyota"))
            {
                System.out.println(car[0] + " " + car[1] + " " + car[2] + " " + car[3]);
            }
        }
    }
}