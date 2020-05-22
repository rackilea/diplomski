package module2;

    import java.io.PrintStream;
    import java.util.Scanner;

    public class SecondSmallest {

        PrintStream out;

        SecondSmallest() {
            out = new PrintStream(System.out);
        }

        void start() {
            Scanner in = new Scanner(System.in);
            out.printf("%s", "Enter multiple numbers divided by a space and close with Enter: ");
            int newNumber;
            int smallestNumber = in.nextInt();
            int secondSmallestNumber = in.nextInt();

            while (in.hasNext()) {
                newNumber = in.nextInt();

                if (newNumber < smallestNumber) {
                    secondSmallestNumber = smallestNumber; 
                    smallestNumber = newNumber;

                } 
            }
        //moved here to print only once 
           out.printf("%s%d\n", "The second smallest number is : ", secondSmallestNumber);
        //flush output stream 
           out.flush();
        }   


        public static void main(String[] argv) {
            new SecondSmallest().start();
        }