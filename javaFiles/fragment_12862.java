private static long fieldPrime = 4294967291L; // 2^32-5
  private static long correctionFactor = fieldPrime+25; //fieldPrime + (2^64) mod fieldPrime 

  public final static long modMult(long a, long b) {
      long r = (a*b);
      if (r>=0)
      {
        return r % fieldPrime;
      }
      else
      {
        return ((r% fieldPrime)+correctionFactor)%fieldPrime;  
      }
  }