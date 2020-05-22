public class SimCraps { 
    public static void main(String[] args) {
        if (args.length > 0) {
            int number = Integer.parseInt(args[0]);
            System.out.println("You entered " + number);
        } else {
            System.out.println("No number provided");
        }
    }
}