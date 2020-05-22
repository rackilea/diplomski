class MyGradeLevels {

    public static void main(String[] args) {
         System.out.println("Please enter your grade to begin!");

         java.util.Scanner input=new java.util.Scanner(System.in); 
         double grade;
        try { 
              grade=input.nextInt();
              if ( grade >= 90 ) {
                 System.out.println("Great Job!");
              } else if( grade <= 49 ) {
                 System.out.println("Needs Improvement!");
              } else {
                 System.out.println("Average Effort!");
              } 
         } 
        catch( java.util.InputMismatchException e ) { 
              System.out.println("Your number isn't right.");

         }

        try { 
              grade=input.nextInt(); 
              System.out.println("Your Final Grade is "+grade); 
         } 
        catch( java.util.InputMismatchException e ) { 
              System.out.println("Please round your number and restart!"); 
         }

         input.close();     
    }
}