package euler;

import fj.F;
import static fj.Function.flip;
import fj.data.Stream;
import static fj.data.Stream.range;
import static fj.function.Integers.multiply;
import static fj.function.Integers.add;
import static fj.pre.Equal.charEqual;
import static fj.pre.Equal.streamEqual;
import static fj.pre.Ord.intOrd;
import static fj.pre.Show.intShow;

/**
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem4
  {private static final F<Integer, Boolean> palindrome =
    new F<Integer, Boolean>() {public Boolean f(final Integer i)
      {final Stream<Character> s = intShow.show(i);
       return streamEqual(charEqual).eq(s.reverse(), s);}}

   public static void main(final String[] a)
     {final Stream<Integer> xs = range(100, 999);
      intShow.println(xs.tails().bind(xs.zipWith(multiply)).filter(palindrome)
                      .foldLeft1(intOrd.max));}}