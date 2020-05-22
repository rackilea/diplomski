import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException,
            IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
            System.in));
        String[] line = reader.readLine().split("\\s");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        int count = 0;
        for (int i = 0; i < n; i++) {
             int t = Integer.parseInt(reader.readLine());
             if (t % k == 0) {
                 ++count;
             }
        }
        System.out.println(count);
   }
}