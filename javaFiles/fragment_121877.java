public static boolean subString(String str1, String str2)
        {
          String s1 = str1.toLowerCase();
          String s2 = str2.toLowerCase();
          for (int offset = 0; offset <= s2.length() - s1.length(); offset++) {
            int i = 0;
            for (; i < s1.length(); i++){
              if(s1.charAt(i) != s2.charAt(i+offset)) {
                break;
              }
            }
            // found a substring that starts at the current offset
            if (i == s1.length())
              return true;
          }
          return false;
        }