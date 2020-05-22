import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class MainClass {


public static void main(String[] args) {
    // TODO Auto-generated method stub

    long count=0;
    try{

        File file = new File("bigfile.txt");
        PrintWriter writer = new PrintWriter(file, "UTF-8");


        Random random = new Random();
        for(int i = 0; i < 23695522; i++)
        {           
            char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            count+=word.length;
            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(26));

            }
            writer.print(new String(word) + ' ');
            count+=1;
            if (i % 10 == 0){
                writer.println();
                count+=2;

            }
        }


        writer.close();
    } catch (IOException e) {
       // do something
    }




    System.out.println(count);

}