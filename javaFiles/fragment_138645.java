String text = "こんにちは";
byte[] array = text.getBytes("UTF-8");
String s = new String(array, Charset.forName("UTF-8"));
System.out.println(s); // Prints as expected
String sISO = new String(array, Charset.forName("ISO-8859-1")); // Prints 'ããã«ã¡ã¯'
System.out.println(sISO);