// This is a pretty common one-byte charset.
Charset charset = StandardCharsets.ISO_8859_1;

// This is another common one-byte charset.  You must use the same charset
// that was used to write the bytes in your ObjectiveC program.
//Charset charset = Charset.forName("windows-1252");

CharBuffer c = charset.newDecoder().decode(mBuf);
char[] charBuff = new char[c.remaining()];
c.get(charBuff);