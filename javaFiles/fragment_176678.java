public static void main(String[] args)  {
    testString("x:y", "Marty:McFly");
    testString("x?y", "Marty?McFly");
    testString("y:x", "Marty:McFly");
    testString("y?x", "Marty?McFly");
  }

  /**
   * 
   */
  private static void testString(String format, String string) {
    String regex = "(\\w)(\\W)(\\w)";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(format);

    if (!matcher.find()) throw new IllegalArgumentException("no match found");

    String delimiter = matcher.group(2);

    String param1 = matcher.group(1); 
    String param2 = matcher.group(3); 


    String[] split = string.split("\\" + delimiter);
    String x;
    String y;
    switch(param1.compareTo(param2)) {
      case 1:
        x = split[1];
        y = split[0];
        break;
      case -1:
      case 0:
      default:
        x = split[0];
        y = split[1];
    };

    System.out.println("String x: " + x);
    System.out.println("String y: " + y);

    System.out.println(String.format("%s%s%s", x, delimiter, y));
    System.out.println();
  }