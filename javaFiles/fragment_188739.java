final static String DELIM = "<<Jee Seok Yoon's Unique Delimiter>>";
String a = /*...*/;
String b = /*...*/;
String combined = a + DELIM + b;

int breakAt = combined.indexOf(DELIM);
String a1 = combined.substring(0, breakAt);
String b1 = combined.substring(breakAt + DELIM.length());