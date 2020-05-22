import java.security.SecureRandom;

public class StringUtils
{
  private static final SecureRandom RANDOMSOURCE;
  private static String CANDIDATES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

  static
  {
    RANDOMSOURCE = new SecureRandom();
  }

 /**
  * Generate a random string of alphanumeric characters.
  * <p>
  * The string returned will contain characters randomly
  * selected from upper- and lower-case a through z as
  * well as the digits 0 through 9.
  * @param length the length of the string to generate
  * @return a string of random alphanumeric characters of the requested length
  */
  public static String generateRandomString(int length)
  {
    final StringBuffer sb = new StringBuffer(length);
    for (int i = 0; i < length; i++)
    {
      sb.append(CANDIDATES.charAt(RANDOMSOURCE.nextInt(62)));
    }
    return sb.toString();
  }
}