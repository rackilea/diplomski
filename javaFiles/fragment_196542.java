import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line;

        //read line untill it's not null or empty
        while ((line = in.nextLine()) != null && !line.isEmpty()) {
            //split line by regex \s (whiteSpace chars)
            String[] ints = line.split("\\s");
            //our array could be empty if there was just spaces in line
            if (ints.length == 0)
                return;

            //Think it's understandable
            int count = Integer.parseInt(ints[0]);
            Point[] points = new Point[count];

            //according to line structure, x and y of point number i would be
            // i * 2 + 1 and i * 2 + 2
            for (int i = 0; i < count; ++i) {
                int x = Integer.parseInt(ints[i * 2 + 1]);
                int y = Integer.parseInt(ints[i * 2 + 2]);
                points[i] = new Point(x, y);
            }

            //To achieve output like yours, use Arrays.toString()
            System.out.println(Arrays.toString(points));
        }
    }
}