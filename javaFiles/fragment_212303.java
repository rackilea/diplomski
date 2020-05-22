String string1 = "123456,99";
String string2 = "123456Test99";

Locale userLocale = Locale.forLanguageTag("uk-UK");
DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(userLocale);
decimalFormat.setParseBigDecimal(true);

ParsePosition parsePosition = new ParsePosition(0);
Number number1 = decimalFormat.parse(string1, parsePosition);

if (parsePosition.getIndex() <= string1.length()) {
  System.out.println("Parse error");
} else {
  System.out.println(number1.toString());
}

parsePosition = new ParsePosition(0);
Number number2 = decimalFormat.parse(string2, parsePosition);

if (parsePosition.getIndex() <= string2.length()) {
  System.out.println("Parse error");
} else {
  System.out.println(number2.toString());
}