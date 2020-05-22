import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Square {

    public static void main(String[] args) {
        String a[][] = new String[5][5];
        try {
            FileReader fr = new FileReader("new.txt");
            Scanner scanner=new Scanner(fr);
            ArrayList<String> l = new ArrayList<String>();
            while(scanner.hasNext())
            {
                l.add(scanner.next());
            }
            for(int i = 0; i < l.size(); ++i)
            {
                String toSplit = l.get(i);
                String[] splitted = toSplit.split("");
                for(int j = 0; j < splitted.length; ++j)
                {
                    a[i][j] = splitted[j];
                }
            }
            scanner.close();
        } 

        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // test the result
        for(int i = 0; i < a.length; ++i)
        {
            for(int j = 0; j < a[i].length; ++j)
            {
                System.out.println(a[i][j]);
            }
        }
    }
}