import org.junit.Test;
import org.junit.experimental.theories.*;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class PrimeTest {

    @Theory
    public void isPrime(int candidate) {
          // called with candidate=1, candidate=2, etc etc  
    }

    public static @DataPoints int[] candidates = {1, 2, 3, 4, 5};
}