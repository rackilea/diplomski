Integer[] primes=new Integer[3];
if(primes[0]>0) {
  synchronized(primes[0]) {
    int returning=primes[0];
    primes[0]=0;
    returning.notifyAll();
    return returning;
  }
}