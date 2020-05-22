public class TestLoops {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean thisB = false; /*this is the guy who will tell the loop to stop the execution when the user inserts X*/
        String shape;
        do{
            System.out.println("What is your shape? Enter C for circle, S for " +
                    "square, R for rectangle, or X to exit: ");
            shape = input.next();

            if(shape.equalsIgnoreCase("C") || shape.equalsIgnoreCase("S") || shape.equalsIgnoreCase("R")) {
                if (shape.equals("C")) {
                    System.out.println("What is your circle's radius?: ");
                    double Radius = input.nextDouble();
                    double cFormula = (3.14 * Radius * Radius);
                    System.out.println("Your circle's area = " + cFormula);
                } else if (shape.equals("S")) {
                    System.out.println("What is the length of your shape's sides?: ");
                    double Side = input.nextDouble();
                    double sFormula = (Side * Side);
                    System.out.println("Your square's area = " + sFormula);
                } else if (shape.equals("R")) {
                    System.out.println("What is your rectangle's height?: ");
                    double Height = input.nextDouble();
                    System.out.println("What is your rectangle's width?: ");
                    double Width = input.nextDouble();
                    double rFormula = (Height * Width);
                    System.out.println("Your rectangle's area = " + rFormula);
                }
            }
            else if (shape.equalsIgnoreCase("X")) thisB = true;/*or in other words: stop*/
        }
        while(!thisB);
    }

}