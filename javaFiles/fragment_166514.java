import java.io.*;

public class addition {
public static void main(String array[])throws IOException
{
    InputStreamReader i = new InputStreamReader(System.in);
    BufferedReader b = new BufferedReader(i);
    System.out.println("Enter first number : ");

    // Attempt to read in user input.
    try {
        int a1 = Integer.parseInt(b.readLine());
        System.out.println("Enter second number : ");
        int a2 = Integer.parseInt(b.readLine());
        int sum = a1 + a2 ;
        System.out.println("addition"+sum);
    }

    // Should there be some problem reading in input, we handle it gracefully.
    catch (IOException e) {
        System.out.println("Error reading input from user. Exiting now...");
        System.exit(0);
    }
}
}