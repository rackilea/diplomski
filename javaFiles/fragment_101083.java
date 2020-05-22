import java.util.stream.*;
import java.util.function.IntPredicate;

public class Primes {

   static IntPredicate isPrime = x -> true;
   static IntStream primes = IntStream
                               .iterate(2, i -> i + 1)
                               .filter(i -> isPrime.test(i))
                               .peek(i -> isPrime = isPrime.and(v -> v % i != 0));

   public static void main(String[] args) {
      // Print out the first 10 primes.
      primes.limit(10)
            .forEach(p -> System.out.println(p));

   }
}