public static final String KANJI = "";

  public static void main(String[] args)
  {
    System.out.println(KANJI.length());                         // 6
    System.out.println(KANJI.codePointCount(0, KANJI.length()));// 3

    // Loop over each code point
    for (int i = 0; i < KANJI.length(); )
    {
      System.out.println(KANJI.codePointAt(i));
      i = KANJI.offsetByCodePoints(i, 1);
    }

    // Extract the third codepoint
    int indexForThirdCodePoint = KANJI.offsetByCodePoints(0, 2);
    int thirdCodePoint = KANJI.codePointAt(indexForThirdCodePoint);
    System.out.println(thirdCodePoint);

    // Convert codepoint back to string
    System.out.println(new String(Character.toChars(thirdCodePoint)));
  }