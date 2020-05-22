import java.util.Scanner;

public class Range {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Please input your frist number.");
        int input1 = red(console);
        System.out.println("Please input your second number.");
        int input2 = red(console);
        printRange(input1, input2);
    }

    public static int red(Scanner console) {
        int x = console.nextInt();
        return x;
    }

    public static void printRange(int input1, int input2) {
        System.out.print("[");

        if (input1 > input2) {
            for (int Z = input1; Z >= input2; Z--) {
                if(Z != input1){
                    System.out.print( ", " );
                }
                System.out.print( Z );
            }
        } else if (input1 < input2) {
            for (int Z = input1; Z <= input2; Z++) {
                if(Z != input1){
                    System.out.print( ", " );
                }
                System.out.print( Z );
            }
        } else {
            System.out.print( input1 );
        }
        System.out.print( "]" );
    }
}