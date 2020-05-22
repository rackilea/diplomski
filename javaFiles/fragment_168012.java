import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class Splitter {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/test.txt")));
        String row;
        while ((row = input.readLine()) != null) {
            String[] fields = row.split(" ");
            System.out.println(String.format("id: %s firstname: %s lastname: %s street: %s city %s", fields[0], fields[1], fields[2], fields[3], fields[4]));
        }
    }
}