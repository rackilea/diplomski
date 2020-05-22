// test string
String text = "Hello world!";
System.out.println("Test string = " + text);

// convert to big integer
BigInteger bigInt = new BigInteger(text.getBytes());
System.out.println(bigInt.toString());

// convert back
String textBack = new String(bigInt.toByteArray());
System.out.println("And back = " + textBack);