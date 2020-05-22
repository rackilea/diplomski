String s=…;
CharsetEncoder enc=StandardCharsets.UTF_8.newEncoder();
ByteBuffer bb=ByteBuffer.allocate(60);// note the limit
CharBuffer cb = CharBuffer.wrap(s);
CoderResult r = enc.encode(cb, bb, true);
if(r.isOverflow()) {
    System.out.println(s+" is too long for "
                      +bb.capacity()+" "+enc.charset()+" bytes");
    s=cb.flip().toString();
    System.out.println("truncated to "+s);
}