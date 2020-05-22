Collections.sort(results, new Comparator<String>() {
  public int compare(String str1, String str2) {
     // obtain the number you'll use to compare
     int value1 = getImportantNumber(str1);
     int value2 = getImportantNumber(str2);
     // return comparator (remember, the sign of the results says if it's <, =, >)
     return value1 - value2;
  }

  // this method will extract the number, maybe you'll need a regex or substring, dunno
  private int getImportantNumber(String str) {
     // by example
     Matcher m = PATTERN.matcher(str);
     if (!m.find())
        return -1; // or throw an exception, depends on you're requirements
     String numberPart = m.group(...); // the number of the group catching the part you need
     return Integer.parseInt(numberPart);
  }

  private static Pattern PATTERN = Pattern.compile("...."); 
});