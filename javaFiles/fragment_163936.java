public static boolean evaluate(String input)
{
  Pattern compile = Pattern.compile("(\\d+)\\s*([<>=]+)\\s*(\\d+)");
  Matcher matcher = compile.matcher(input);
  if (matcher.matches())
  {
    String leftPart = matcher.group(1);
    String operatorPart = matcher.group(2);
    String rightPart = matcher.group(3);

    int i1 = Integer.parseInt(leftPart);
    int i2 = Integer.parseInt(rightPart);

    if (operatorPart.equals("<")) return i1 < i2;
    if (operatorPart.equals(">")) return i1 > i2;
    if (operatorPart.equals("=")) return i1 == i2;
    if (operatorPart.equals("<=")) return i1 <= i2;
    if (operatorPart.equals(">=")) return i1 >= i2;

    throw new IllegalArgumentException("invalid operator '" + operatorPart + "'");
  }

  throw new IllegalArgumentException("invalid format");
}