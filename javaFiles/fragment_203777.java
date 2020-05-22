Scanner input = new Scanner (System.in);
System.out.println("How many stores are there?: ");
int stores = input.nextInt();
int s = 0;
System.out.println("GRAPH OF TOTAL SALES"); System.out.println("(Each * = $100)");

for(int i1 = 0; i1 < stores; i1++) {
   System.out.println("Enter the total sales for Store " + (i1 + 1) + " : ");
   System.out.print( "Store " + (i1 + 1) + " : ");
   s = input.nextInt();
   for(int t = 0; t < s/100; t++) {
      System.out.print("*");
   }
   System.out.println( );
}
input.close();