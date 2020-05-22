import java.util.Scanner;

    public class Swap {
        public static void main(String[] args) {
            Scanner keyboardIn = new Scanner(System.in);

            /* enter code here */int[] numbers = new int[] { 12, 9, 33, 28, 5 };
            int temp = 0, first, second;
            int index1 = 0 , index2 = 0;
            int j , k ;

            System.out.println("Before the swap: ");
            for (int i = 0; i < numbers.length; i++) {
                System.out.print(numbers[i] + " ");

            }
            System.out.println();
            System.out.println("Enter the first number to swap:");
            first = keyboardIn.nextInt();
            System.out.println("Enter the second number to swap:");
            second = keyboardIn.nextInt();
            System.out.println();
            for(k = 0 ; k < numbers.length; k++){
                if(numbers[k] == first)
                    index1 = k;
            }
            for(j = 0 ; j < numbers.length; j++){
                if(numbers[j] == second)
                    index2 = j;
            }
            temp = numbers[index1];
            numbers[index1] = numbers[index2];
            numbers[index2] = temp;

            System.out.println("After the swap:");
            for (int i = 0; i < numbers.length; i++) {
                System.out.print(numbers[i] + " ");
            }
        }
    }