import java.util.Scanner;

public class PositiveNegative {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String answer;
        do {
            System.out.print("Input a list of integers (end with 0): ");
            int nums = input.nextInt();

            int pos = 0;
            int neg = 0;
            int total = 0;
            int count = 0;
            double avg = 0;

            while (nums != 0) {
                if (nums >= 1) {
                    pos++;
                } else {
                   neg++;
                }
                total = total + nums;
                count++;

                avg = total * 1.0 / count;

                System.out.print("Input a list of integers (End with 0): ");
                nums = input.nextInt();
            }

            if(count == 0) {
                System.out.print("No numbers were entered except 0");
            } else {
                System.out.print("# of positives are: " + pos + "\n" + "# of negatives are : " + neg + "\n" + "The total: " + total + "\n" + "The average: " + avg);
            }
            System.out.print("\nWould you like to continue with new inputs? ");
            answer = input.next();
        } while (answer.equalsIgnoreCase("Yes"));
    }  
}