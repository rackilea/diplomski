String myString = "Feng shui in chinese is 風水";
byte[] bytes1 = myString.getBytes("UTF-8");  // Bytes correct
byte[] bytes2 = myString.getBytes("US-ASCII"); // Last 2 characters are now corrupted (converted to question marks)

String nordic = "Här är några merkkejä";
byte[] bytes3 = nordic.getBytes("UTF-8");  // Bytes correct, "weird" chars take 2 bytes each
byte[] bytes4 = nordic.getBytes("ISO-8859-1"); // Bytes correct, "weird" chars take 1 byte each
String broken = new String(nordic.getBytes("UTF-8"), "ISO-8859-1"); // Contains now "HÃ¤r Ã¤r nÃ¥gra merkkejÃ¤"