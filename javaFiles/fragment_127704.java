public static void allMatches(String text, String regex)
{
  Matcher m = Pattern.compile(regex).matcher(text);
  int end = text.length();
  for (int i = 0; i < end; ++i)
  {
    for (int j = i + 1; j <= end; ++j) 
    {
      m.region(i, j);

      if (m.find()) 
      {   
        System.out.printf("Match found: \"%s\" at position [%d, %d)%n",
                          m.group(), i, j);
      }   
    }   
  }   
}