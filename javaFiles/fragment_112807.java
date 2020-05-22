import java.util.ArrayList;
import java.util.Scanner;

public class ReadFromKeyboard {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String inStr = input.next();
        int n = 0;
        int i;
        int count = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        double average = 0;
        int sum;
        double deviation = 0;
        int total;
        double temp = 0;// correction here because it must store double or float value

        ArrayList<Integer> n1 = new ArrayList<Integer>();// i used this to store all entered values

        while (!inStr.equals("EOL")) {
            count++;
            n = Integer.parseInt(inStr);
            min = Math.min(min, n);
            max = Math.max(max, n);
            System.out.printf("%d ", n);
            n1.add(n);
            inStr = input.next();
            average += n;

        }

        average = average / count; // this will give you final average

        for (int j = 0; j < count; j++) {
            temp += Math.pow(n1.get(j) - average, 2);
        }
        //System.out.println("\n" + temp + " " + count);
        deviation = Math.sqrt(temp / count); // this is your standard deviation

        //System.out.println(deviation);

        System.out.println("\n The average of these numbers is " + average);
        System.out.printf("The list has %d numbers\n", count);
        System.out.printf("The minimum of the list is %d\n", min);
        System.out.printf("The maximum of the list is %d\n", max);
        System.out.println("The standard deviation of the list is " + deviation);

        input.close();

    }
}