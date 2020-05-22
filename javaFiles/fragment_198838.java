public static boolean hasBAB(String str) {
      String searchString = "bab";

      // Base cases
      if (str.length() < searchString.length()) 
          return false;

      if (str.length() == searchString.length())
      {
          if (str.equals(searchString))
          {
              return true;
          }
          return false;
      }

      int halfWay = str.length()/2;

      // Now check for the search string over the "break"
      for (int i = 0; i < searchString.length(); i++)
      {
          int startIndex = halfWay - 1 - i;
          int endIndex = startIndex + 3;
          if (startIndex >= 0)
          {
              String substring = str.substring(startIndex, endIndex);
              if (substring.equals(searchString))
              {
                  return true;
              }
          }
      }

     // Recursive Cases 
     //  We did find the search string over the break,so break the string into two equal(ish) pieces and check those 
     if(hasBAB(str.substring(0,halfWay -1)))
         return true;

     if(hasBAB(str.substring(halfWay, str.length())))
         return true;

     return false;
}