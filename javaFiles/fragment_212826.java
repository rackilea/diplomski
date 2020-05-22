String s = "Then someone decided to go to the high street for a drink";

Pattern p = Pattern.compile("(\\w+\\s*(road|street|square|rd|st|sq)\\W+)");

Matcher m = p.matcher(s);

System.out.println(m.find());   // prints true
System.out.println(m.group());  // prints "high street"