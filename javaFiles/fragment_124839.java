//i suspect your problem is here - make sure your encoding the string correctly from the byte/char stream. That is, make sure that you want "iso-8859-1" as your input characters. 

Charset charsetE = Charset.forName("iso-8859-1");
CharsetEncoder encoder = charsetE.newEncoder();

//i believe from here to the end will probably stay the same, as per your posted example.
Charset charsetD = Charset.forName("UTF-8");
CharsetDecoder decoder = charsetD.newDecoder();

ByteBuffer bbuf = encoder.encode(CharBuffer.wrap(inputString));
CharBuffer cbuf = decoder.decode(bbuf);
final String result = cbuf.toString();
System.out.println(result);