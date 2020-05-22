String data = new String(new char[28]).replace("\0", Character.toString ((char) 28));

String newdata = plaintext+data;
newdata = newdata.substring(0,32);
byte [] dataBytes = newdata.getBytes(Charset.forName("ASCII"));
System.out.println(dataBytes);