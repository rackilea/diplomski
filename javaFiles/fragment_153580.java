import java.util.Scanner;

public class TestProgram {

    public static void main(String[] args) {
        System.out.println("Enter number upto which you want to print: ");
        Scanner input = new Scanner(System.in);
        int x;
        x = input.nextInt();

        for (int i = 1; i <= x; i++) {
            if(i%4 == 0 && i%7 == 0) {
                System.out.println("qqqqseven");
            } else if(i%4 == 0) {
                System.out.println("qqqq");
            } else if(i%7 == 0){
                System.out.println("seven");
            } else {
                System.out.println(i);
            }
        }
        input.close();
    }
}