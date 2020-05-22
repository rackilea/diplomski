public static void main(String[] args)
{
    //Determine the range of prime numbers to print
    Scanner scan = new Scanner(System.in);
    System.out.print("Primes smaller than what number should be printed?: ");
    int max = Integer.parseInt(scan.nextLine());

    //Identify how prime numbers will be tested
    PrimeNumberTest test = new BruteForcePrimeNumberTest();

    //Uncomment the line below if you want to include the number 1. Favour adding it here so that you may
    //use re-use your prime number test elsewhere that atually needs to know if a number is prime.
    //System.out.println(1);

    //Print the prime numbers
    for (int i = 2; i < max ; i++)
    {
        if(test.isPrime(i))
        {
            System.out.println(i);
        }
    }
}