String a = /*...*/;
String b = /*...*/;
String combined = String.valueOf(a.length()) + "|" + a + b;

int breakAt = combined.indexOf("|");
int len = Integer.parseInt(combined.substring(0, breakAt), 10);
String a1 = combined.substring(breakAt + 1, len);
String b1 = combined.substring(breakAt + 1 + len);