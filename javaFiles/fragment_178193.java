import java.util.*;
public class Primes {

  private ArrayList<Integer> listOfPrimeNumbers;

  public Primes( int initialCapacity) {
    listOfPrimeNumbers = new ArrayList<Integer>(initialCapacity);    
    //how do I get the above...
    int index = 2;
    while (index != listOfPrimeNumbers.size())
    {
      if (isPrime(index))
      {
        listOfPrimeNumbers.add(index);  
      }
      index++;
    }
  }
  public static boolean isPrime(int candidateNo) {
    Iterator<Integer> iter = listOfPrimeNumbers.iterator( );
    //in here ! ?
    i=2;
    while ( iter.hasNext( ) ) {
      if (candidateNo%i==0 && i!=1) {
        return false;
      }
      else
        return true;
    }
  }