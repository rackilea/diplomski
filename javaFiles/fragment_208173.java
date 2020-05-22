import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        String[] str = { "a", "b", "c" };
        BufferedWriter wr = new BufferedWriter(new FileWriter(new File(
                System.getProperty("user.dir") + File.separator + "test.csv")));
        for (String string : str) {
            wr.write(string + ",");
        }
        wr.flush();
        wr.close();
    }
}