/**
 * @param args the command line arguments
 */
 public static void main(String[] args) {

     Double calculations = 0;
     String choice = "y";
     while (choice.equalsIgnoreCase("y")) {
         ...
         Double innerCalculation = 0;
         innerCalculation = out - in;
         calculations += innerCalculation;
         System.out.println("Total hours of the day: " + innerCalculation);
         ...
     }
     System.out.println("Total hours of all time: " +calculations);
 }