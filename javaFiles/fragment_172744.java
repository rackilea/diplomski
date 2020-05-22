import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Post1 {

    public static void main(String[] args) throws FileNotFoundException {
         String[] transformedNames = readData("/Users/kuma/Desktop/post1.txt");
         System.out.println(Arrays.toString(transformedNames));
    }

    public static String[] readData(String file) throws FileNotFoundException {
        Scanner x = new Scanner(new File(file));
        List<String> list = new ArrayList<>();

        while(x.hasNextLine()) {
            list.add(x.nextLine());
        }
        x.close();
        String[] name = new String[list.size()];

        list.toArray(name);

        String[] transformedNames = new String[list.size()];

        for(int i = 0; i < name.length; i++ ) 
            transformedNames[i] = name[i].replace(" ", "--");

        return transformedNames;
    }

}