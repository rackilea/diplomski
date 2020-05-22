public static void main (String[] args) {
        Scanner stdin = new Scanner (System.in);

        double November, December, January;

        double average;

        System.out.println("what is the rainfall for November?");
        November = stdin.nextDouble();

        System.out.println("what is the rainfall for December?");
        December = stdin.nextDouble();

        System.out.println("what is the rainfall for January?");
        January = stdin.nextDouble();

        System.out.println("the rainfall for November is: \t "  + November );
        System.out.println("the rainfall for December is: \t "  + December );
        System.out.println("the rainfall for January is: \t "  + January );

        average = (November + December + January)/3;
        System.out.println("The average is " + average );
      }