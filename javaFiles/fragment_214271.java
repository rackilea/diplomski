package krc.utilz;

import java.io.Serializable;
import java.nio.charset.Charset;

/**
 * Generates random values. Extends java.util.Random to do all that plus:<ul>
 * <li>generate random values in a given range, and
 * <li>generate Strings of random characters and random length.
 * </ul>
 * <p>
 * Motivation: I wanted to generate random Strings of random length for test 
 *  data in some jUnit tests, and was suprised to find no such ability in the
 *  standard libraries... so I googled it, and came up with Glen McCluskey's
 *  randomstring function at http://www.glenmccl.com/tip_010.htm. Then I thought
 *  aha, that's pretty cool, but if we just extended it a bit, and packaged it
 *  properly then it'd be useful, and reusable. Cool!
 * See: http://www.glenmccl.com/tip_010.htm
 * See: http://forum.java.sun.com/thread.jspa?threadID=5117756&messageID=9406164
 */
public class Random extends java.util.Random  implements Serializable
{

  private static final long serialVersionUID = 34324;
  public static final int DEFAULT_MIN_STRING_LENGTH = 5;
  public static final int DEFAULT_MAX_STRING_LENGTH = 25;

  public Random() {
    super();
  }

  public Random(long seed) {
    super(seed);
  }

  public double nextDouble(double lo, double hi) {
    double n = hi - lo;
    double i = super.nextDouble() % n;
    if (i < 0) i*=-1.0;
    return lo + i;
  }

  /**
   * @returns a random int between lo and hi, inclusive.
   */
  public int nextInt(int lo, int hi) 
    throws IllegalArgumentException
  {
    if(lo >= hi) throw new IllegalArgumentException("lo must be < hi");
    int n = hi - lo + 1;
    int i = super.nextInt() % n;
    if (i < 0) i = -i;
    return lo + i;
  }

  /**
   * @returns a random int between lo and hi (inclusive), but exluding values
   *  between xlo and xhi (inclusive).
   */
  public int nextInt(int lo, int hi, int xlo, int xhi) 
    throws IllegalArgumentException
  {
    if(xlo < lo) throw new IllegalArgumentException("xlo must be >= lo");
    if(xhi > hi) throw new IllegalArgumentException("xhi must be =< hi");
    if(xlo > xhi) throw new IllegalArgumentException("xlo must be >= xhi");
    int i;
    do {
      i = nextInt(lo, hi);
    } while(i>=xlo && i<=xhi);
    return(i);
  }

  /**
   * @returns a string (of between 5 and 25 characters, inclusive) 
   *  consisting of random alpha-characters [a-z]|[A-Z].
   */
  public String nextString()
    throws IllegalArgumentException
  {
    return(nextString(DEFAULT_MIN_STRING_LENGTH, DEFAULT_MAX_STRING_LENGTH));
  }

  /**
   * @returns a String (of between minLen and maxLen chars, inclusive) 
   *  which consists of random alpha-characters. The returned string matches
   *  the regex "[A-Za-z]{$minLen,$maxLan}". 
   * @nb: excludes the chars "[\]^_`" between 'Z' and 'a', ie chars (91..96).
   * @see: http://www.neurophys.wisc.edu/comp/docs/ascii.html
   */
  public String nextString(int minLen, int maxLen)
    throws IllegalArgumentException
  {
    if(minLen < 0) throw new IllegalArgumentException("minLen must be >= 0");
    if(minLen > maxLen) throw new IllegalArgumentException("minLen must be <= maxLen");
    return(nextString(minLen, maxLen, 'A', 'z', '[', '`'));
  }

  /**
   * @does: generates a String (of between minLen and maxLen chars, inclusive) 
   *  which consists of characters between lo and hi, inclusive.
   */
  public String nextString(int minLen, int maxLen, char lo, char hi)
    throws IllegalArgumentException
  {
    if(lo < 0) throw new IllegalArgumentException("lo must be >= 0");
    String retval = null;
    try {
      int n = minLen==maxLen ? maxLen : nextInt(minLen, maxLen);
      byte b[] = new byte[n];
      for (int i=0; i<n; i++)
        b[i] = (byte)nextInt((int)lo, (int)hi);
      retval = new String(b, Charset.defaultCharset().name());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return retval;
  }

  /**
   * @does: generates a String (of between minLen and maxLen chars, inclusive) 
   *  which consists of characters between lo and hi, inclusive, but excluding
   *  character between 
   */
  public String nextString(int minLen, int maxLen, char lo, char hi, char xlo, char xhi) 
    throws IllegalArgumentException
  {
    if(lo < 0) throw new IllegalArgumentException("lo must be >= 0");
    String retval = null;
    try {
      int n = minLen==maxLen ? maxLen : nextInt(minLen, maxLen);
      byte b[] = new byte[n];
      for (int i=0; i<n; i++) {
        b[i] = (byte)nextInt((int)lo, (int)hi, (int)xlo, (int)xhi);
      }
      retval = new String(b, Charset.defaultCharset().name());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return retval;
  }

}