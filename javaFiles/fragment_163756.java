public static void main(String[] args)
{
   System.out.println("Enter a number");
   Scanner input = new Scanner(System.in);
   int fact = input.nextInt();
    //Call the iterative method
    iFactorial(fact);
    //Call the recursive method
    rFactorial(fact);
}