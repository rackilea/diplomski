byte[] srcBytes = getYourSrcBytes();

//Whatever charset your bytes are endoded in
Charset charset = Charset.forName("UTF-8");
CharsetDecoder decoder = charset.newDecoder();

//ByteBuffer.wrap simply wraps the byte array, it does not allocate new memory for it
ByteBuffer srcBuffer = ByteBuffer.wrap(srcBytes);
//Now, we decode our srcBuffer into a new CharBuffer (yes, new memory allocated here, no can do)
CharBuffer resBuffer = decoder.decode(srcBuffer);

//CharBuffer implements CharSequence interface, which StringBuilder fully support in it's methods
StringBuilder yourStringBuilder = new StringBuilder(resBuffer);