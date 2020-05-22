public static void main( String[] args ) {
    Scanner keyboard = new Scanner(System.in);

    System.out.print( "Hello. What is your name? " );
    String name = keyboard.next();

    System.out.print( "Hi, " + name+ "! How old are you? " );
    int age = keyboard.nextInt();

    System.out.println("So you're " + age + ", eh? That's not so old.");
    System.out.print( "How much do you weigh, " + name + "? " );
    double  weight = keyboard.nextDouble();

    System.out.println( weight + "! Better keep that quiet!!" );
    System.out.print("Finally, what's your income, " + name + "? " );
    double income = keyboard.nextDouble();

    System.out.print( "Hopefully that is " + income + " per hour" );
    System.out.println( " and not per year!" );
    System.out.print( "Well, thanks for answering my rude questions, " );
    System.out.println( name + "." );
}