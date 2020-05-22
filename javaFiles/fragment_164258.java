public class ArgumentExample {

        public static void main(String[] args) {
            int i = 0; // declare a counter here so you can use it in the catch
            double tot = 0.0d; // declare the accumulator variable
            try {
                for (i = 0; i < args.length; i++) { // iterate over arguments...if only one is present returns just that one
                    tot += Double.parseDouble(args[i]); // sum
                }
            } catch (Exception ex) {
                System.out.println("Argument " + i + " is not a number");// print which argument is not a number if any
            }
            System.out.println("Sum is: " + tot/(args.lenght == 0 ? 1 : args.lenght); // final print statement
        }
    }