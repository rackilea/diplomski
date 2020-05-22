int testGrade = -1 ;
Scanner studentInput = new Scanner(System.in);
while (testGrade > 100 || testGrade < 0) 
{
   System.out.println("Your input does not match the criteria, please enter a number between 0 and 100");

   while(!studentInput.hasNextInt())
   {
       studentInput.next() ;
   }
   testGrade = studentInput.nextInt();
}