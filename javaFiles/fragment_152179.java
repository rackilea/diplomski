public static void main(String[] args)
{
    //Determine the range of prime numbers to print
    Scanner scan = new Scanner(System.in);
    System.out.print("Primes smaller than what number should be printed?: ");
    int max = Integer.parseInt(scan.nextLine());

    //Identify how prime numbers will be tested
    Iterable<int> primes = new PrimeNumberTestGenerator(max, new BruteForcePrimeNumberTest());

    //Print the prime numbers
    foreach (int prime : primes)
    {
        System.out.println(prime);
    }
}