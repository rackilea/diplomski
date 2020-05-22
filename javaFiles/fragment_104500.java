@Test
public void test() {
    //instantiate prime object, create primes list, and iterator
    PrimeNumbers prime = new PrimeNumbers();

    int n = 8;
    int unexpectedPrimeNumber = 19;

    // call the method
    prime.computePrimes(n);

    // gather the generated prime numbers into a list for easier assertion
    List<Integer> primeList = new ArrayList<>();
    prime.iterator().forEachRemaining(integer -> primeList.add(integer));

    assertEquals("Should contain " + n + " prime numbers!", n, primeList.size());
    assertFalse("Should not contain the unexpected prime number: " + unexpectedPrimeNumber, primeList.contains(unexpectedPrimeNumber));
}