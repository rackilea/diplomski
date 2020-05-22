import java.io.File;
import java.io.IOException;


    public class MainTest {
        public static void main(String[] args)
        {
            File directory = new File("");
            try {
                System.out.println(directory.getCanonicalPath());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }