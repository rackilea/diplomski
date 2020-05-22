private final static String ZEROES = "0000000000";

// ...

String s = Integer.toString(12345, 8);
String intAsString = s.length() <= 10 ? ZEROES.substring(s.length()) + s : s;