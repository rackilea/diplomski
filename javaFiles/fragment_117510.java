byte[] b = { 37, -39, -112, -32, 123, -40, -114, 121 };
short[] s = new short[b.length / 2];
ByteBuffer buf = ByteBuffer.wrap(b);
// buf.order(ByteOrder.LITTLE_ENDIAN);
for (int i = 0; i < s.length; i++)
    s[i] = buf.getShort();
System.out.println(Arrays.toString(b));
System.out.println(Arrays.toString(s));