import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String s = "480 124 125 001 047 001 047 001 480 001 001 001 001 001 001 001 001 001 001 001 001 047 001 480 002 002 002 002 002 002 002 002\n";

        int header[] = new int[] {1, 47, 1, 480};
        String stringHeader = "";
        for (int e : header) {
            stringHeader += String.format("%03d ", e);
        }
        Scanner scanner = new Scanner(s);
        scanner.useDelimiter(stringHeader);

        // Skipping everything before first header
        scanner.skip(".*?"+stringHeader);

        // Now we get data between headers
        while(scanner.hasNext()) {
            System.out.println(   scanner.next()   );
        }

    }
}