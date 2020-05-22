import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {
    public static int Fact(int n) {
        if (n != 1)
            return n * Fact(n - 1);
        return 1;
    }

    public static void main(String[] args) {
        try {
            int n;
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    System.in));
            System.out.println("Enter a number to find its factorial=");
            String s = br.readLine();
            n = Integer.parseInt(s);
            n = Fact(n);
            System.out.print("The Factorial is " + n);
        } catch (IOException e) {
            // bla
        }
    }
}