try{
   System.out.print("Enter your number: ");
   int number=sc.nextInt();
    }catch(Exception ex)  {
       System.out.pritnln("please enter a valid number");
       ex.printStackTrace();
    }


if (number>0)
    {
        for (count=1; count<=number; count++)
        factorial = factorial*count;

        System.out.println("Factorial of your number is: "+factorial);
        System.out.println();
    }
else
{
    System.out.println("Enter a positive whole number greater than 0");
}