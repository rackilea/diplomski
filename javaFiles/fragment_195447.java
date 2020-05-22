Scanner sc = new Scanner(System.in);
int number;
System.out.println("Enter a number to find the factorial of it: ");
number= sc.nextInt();
int factor = 1;
// edit the condition so numbers that fall outside the range 0-10 will cause the error
// message to display
if (number < 1 || number > 10)
    System.out.println("Invalid!! the number has to be between 1 and 10");
else {
    for( int x=1; x<=number; x++ )
    {
        factor = factor*x;
    }
    System.out.println("The factorial of  "+number+" is = " +factor);
}