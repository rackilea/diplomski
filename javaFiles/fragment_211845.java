import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class TestJava{
    public static void main(String[] args){
        ArrayList<String> values = new ArrayList<>();
        values.add("bat");
        values.add("ball");
        values.add("print");
        BufferedWriter wr = null;
        try {
            wr = new BufferedWriter(new FileWriter("output.txt"));
            for (String var : values) {
                wr.write(var);
                wr.newLine();
            }
            wr.close();

        } catch (Exception e) {
            //TODO: handle exception
        }

    }
}