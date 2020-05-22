public static String removeEverySecondChar(String str) {
    if(str.length() < 2) {
      return str;
    }
    return str.substring(0,1) + removeEverySecondChar(str.substring(2));
  }