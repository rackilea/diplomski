ParsePosition parsePosition = new ParsePosition(0);
format.parse(value1, parsePosition); // ok
System.out.println(parsePosition.getIndex() == value1.length());
parsePosition = new ParsePosition(0);
format.parse(value2, parsePosition); // ok, but it's not german format
System.out.println(parsePosition.getIndex() == value2.length());