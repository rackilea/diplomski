import java.util.Scanner;

class programTwo {


    public static void main (String[] args) {

        Scanner scan = new Scanner(System.in);
        double values[] = new double[20];
        int count = 0;
        System.out.println ("Enter your numbers to be averaged. Remember no more than 20!:");
        String inputs = scan.nextLine();
        scan = new Scanner(inputs); // create a new scanner out of our single line of input
        while(scan.hasNextDouble())
        {
            if(count == 20)
            {
                System.out.println("You entered too many numbers! Fail.");
                return;
            }
            values[count] = scan.nextDouble();
            count += 1;
        }

        System.out.println("Your average is: " + average(values, count));
    }

    public static double average(double [] values, int count) {
        double average = 0.0;
        for (double value : values) {
            average += value;
        }
        average /= count;

        return average;
    }

}