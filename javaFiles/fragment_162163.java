public static void main (String[] args)
{
    String[] names = new String[5];
    double[] sales = new double[5];
    Scanner scan = new Scanner(System.in);

    for (int i=0; i<5; i++) {
         System.out.println ("What is the name of the person?");
         name[i] = scan.next();
         System.out.println ("How much did they sell?");
         sales[i] = scan.nextDouble();
    }
    for (int i=0; i<5; i++) {        
        System.out.println (name[i] + " sold " + sales[i]);
    }
}