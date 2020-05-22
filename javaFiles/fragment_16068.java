import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileIO 
{
    public static void main(String[] args) 
    {
        File file = new File("c:/temp/");

        // Reading directory contents
        File[] files = file.listFiles();

        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }

        // Reading conetent

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("c:/temp/test.txt"));
            String line = null;

            while(true)
            {
                line = reader.readLine();
                if(line == null)
                    break;

                System.out.println(line);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(reader != null)
            {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}