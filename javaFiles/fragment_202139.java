public void print() {
  int i = 1; 
  for (Integer nextPrime:listOfPrimeNumbers) {
      System.out.println("the " + i + "th prime is: " + nextPrime);
      i++;
  }
}