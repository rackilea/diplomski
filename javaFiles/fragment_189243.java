public boolean isPrime(long num) {
  if (num & 1 == 0) {
    return false; // checks divisibility by 2
  }
  for (long i=3; i*i<=num; i+=2) {
    if (num % i == 0) {
      return false;
    }
  }
  return true;
}