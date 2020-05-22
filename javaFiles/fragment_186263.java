import java.util.Scanner;
    public class LinGlj4u {

        public static void main(String[] args) {

            Scanner input = new Scanner(System.in);
            System.out.print("Bitte geben sie den Wert für a ein : ");
            double  a = input.nextDouble();
            System.out.print("Bitte geben sie den Wert für b ein : ");
            double b = input.nextDouble();

            if(a != 0) {
                System.out.println("result is " +(-b/a));
            } else {
                System.out.println("result is infinity");
            }
        }

     }