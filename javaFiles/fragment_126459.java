int count = 0;
for(int number = 11; number<=limit; number++){
  if(isPrime(number))
  {
      System.out.println(number);
      count++;
  }
}
System.out.println("Number of primes are :"+count);