public static final String KANJI = "";

public static int lengthCodepoints(String s)
{
  return s.codePointCount(0, s.length());
}

public static String substringCodepoint(String s, int startCodepoint, int numCodepoints)
{
  int startIndex = s.offsetByCodePoints(0, startCodepoint);
  int endIndex = s.offsetByCodePoints(startIndex, numCodepoints);
  return s.substring(startIndex, endIndex);
}

public static void main(String[] args)
{
  int cpLength = lengthCodepoints(KANJI);
  for (int i = 0; i < cpLength; ++i)
  {
    System.out.println(substringCodepoint(KANJI, i, 1));
  }
}