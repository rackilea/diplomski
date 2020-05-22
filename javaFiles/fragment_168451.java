public static void main(String[] args) {
    Scanner read = new Scanner(System.in);

   System.out.println("How many names do you wish to enter?");
   int numOfNames = read.nextInt();

   String [] names = new String[numOfNames];

   System.out.println("Enter the names.");
   int items = 0;
   names[items] = read.nextLine();
   while ( items < numOfNames)
   {
       names[items] = read.nextLine();
       items++;
   }

   System.out.println("You entered the following names");

   for ( int i = 0; i < numOfNames; i++) {
      System.out.print(names[i] + " ");
   }

   System.out.println();
}