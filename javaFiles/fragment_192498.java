public static void main(String args[]) throws InterruptedException {
String key = "Hello world";// plaintext
byte[] x = key.getBytes();
StringBuilder sb = new StringBuilder();
for (int i = 0; i < x.length; i++) {
    int b = (int) x[i];
    sb.append(Integer.toHexString(b));
}
System.out.println(sb.toString());
}