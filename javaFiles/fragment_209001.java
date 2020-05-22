import java.util.HashMap;
import java.util.Map;

class Example {

  static void factor(long N, Map<Long, Short> primesWithMultiplicity) {
    // some arg checking and trivial cases
    if(N<0) N=-N;
    if(0==N) {
       throw new IllegalArgumentException(
         "Are you kidding me? Every number divides 0, "+
         "you really want them all listed?"
       );
    }
    if(1==N) {
      primesWithMultiplicity.put(1L,(short)1);
      return;
    }

     // don't try divisors higher than sqrt(N), 
    // if they would have been detected by their composite-complement 
    for(long div=2; div*div < N; ) {
      short multiplicity=0;
      while((N % div)==0) {
        multiplicity++;
        N /= div; // reduce N
      }
      if(multiplicity>0) {
        primesWithMultiplicity.put(div, multiplicity);
      }
      div+= (div == 2 ? 1 : 2); // from 2 to 3, but then going only on odd numbers
    }
    // done.. well almost, if N is prime, then 
    // trying to divide up to sqrt(N) will lead an empty result. But,
    // in this case, N will still be at original value (as opposed 
    // to being 1 if complete factored)
    if(N>1) {
      primesWithMultiplicity.put(N, (short)1);
    }
  }

  static int countDistinctCompositePairs(long N) {
    HashMap<Long, Short> factoringResults=new HashMap<>();
    factor(N, factoringResults);
    int ret=1;
    for(short multiplicity : factoringResults.values()) {
      ret*=multiplicity;
    }
    return ret/2;
  }

  static public void main(String[] args) {
    System.out.println(countDistinctCompositePairs(24));
  }
}