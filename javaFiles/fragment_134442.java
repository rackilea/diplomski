import java.util.Scanner;

public class InputSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter positive integers. Enter -1 to stop. ");
        int number = 0;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        do{
            try {
                number = scan.nextInt();

                if(number < -1){
                    System.out.println("Invalid input. Try again.");
                }else if(number > -1){
                    sum += number;
                    sb.append(number + " ");
                }

            } catch (InputMismatchException e) { // handle invalid integers
                System.out.println("Invalid input. Try again.");
            }
        }while (number != -1);

        System.out.println("Numbers entered: " + sb.toString().trim() + ".");
        System.out.println("The sum: " + sum + ".");
    }
}