public static boolean isBetween(int x, int lower, int upper) {
  return lower <= x && x <= upper;
}

switch(Grade_Average)  {
 case isBetween(90, 100):
   System.out.println( " Your average test score is " + Grade_Average );
   System.out.println( "Your letter grade is an A." );
   break;
 case isBetween(80, 89):
   System.out.println( " Your average test score is " + Grade_Average );
   System.out.println( "Your letter grade is a B." );
   break;
 case isBetween(70, 79):
   System.out.println( " Your average test score is " + Grade_Average );
   System.out.println( "Your letter grade is a C." );
   break;     
 case isBetween(65, 69):
   System.out.println( " Your average test score is " + Grade_Average );
   System.out.println( "Your letter grade is a D." );
   break;
 case isBetween(0, 64):
   System.out.println( " Your average test score is " + Grade_Average );
   System.out.println( "Your letter grade is a F." );
   break;
default:
   System.out.println( " Invalid test score. ");
   break;
}