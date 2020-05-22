import java.math.BigInteger;
import static java.math.BigInteger.ZERO;
import static java.nio.charset.StandardCharsets.US_ASCII;
import static java.util.Arrays.copyOf;
import static java.lang.Math.max;

public class InterpolationSearch {
  static int interpolate(String ys, String xs, String iOfTs, int id) {
    int maxLen = max(max(xs.length(), ys.length()), iOfTs.length());
    BigInteger x = new BigInteger(1, copyOf(xs.getBytes(US_ASCII), maxLen));
    BigInteger y = new BigInteger(1, copyOf(ys.getBytes(US_ASCII), maxLen));
    BigInteger iOfT = new BigInteger(1, copyOf(iOfTs.getBytes(US_ASCII), maxLen));
    BigInteger d = BigInteger.valueOf(id);
    BigInteger den = x.subtract(y);
    return ZERO.equals(den) ? 0 : (int) d.multiply(iOfT.subtract(y)).divide(den).longValue();
  }

  static int search(String [] a, String target) {
    int p = 0;
    int q = a.length - 1;
    while (target.compareTo(a[p]) >= 0 && target.compareTo(a[q]) <= 0) {
      int m = p + interpolate(a[p], a[q], target, q - p);
      int cmp = target.compareTo(a[m]);
      if (cmp < 0) q = m - 1;
      else if (cmp > 0) p = m + 1;
      else return m;
    }
    return -1; // search fail
  }

  public static void main(String [] args) {
    String [] data = {
      "bbbb",
      "cccccccc",
      "ddd",
      "eeeeeee",
      "fffff",
      "ggggggggggggggg",
      "hhhhh",
    };   
    for (int i = 0; i < data.length; ++i) {
      System.out.println(search(data, data[i]));
    }
    System.out.println(search(data, "bbb"));
    System.out.println(search(data, "hhhhhh"));
    System.out.println(search(data, "eeeee"));
  }
}