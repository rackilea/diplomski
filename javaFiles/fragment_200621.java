// bytes is a byte[] containing ASCII
char[] chars = new char[bytes.length];
for(int i = 0; i < bytes.length; ++i) {
   chars[i] = decoded[bytes[i] & 0xFF];
}
String s = new String(chars);
System.out.println(s);