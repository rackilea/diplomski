public enum StringUtils
{
  INSTANCE;

  private static final String CANDIDATES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
  private static final int CANDIDATESLEN;

  static
  {
    CANDIDATESLEN = CANDIDATES.length();
  }

  public static String generateRandomString(int length)
  {
    final StringBuffer sb = new StringBuffer(length);
    for (int i = 0; i < length; i++)
    {
      sb.append(CANDIDATES.charAt(RANDOMSOURCE.nextInt(CANDIDATESLEN)));
    }
    return sb.toString();
  }
}