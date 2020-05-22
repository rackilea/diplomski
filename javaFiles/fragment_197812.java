private void p(String s) {
    System.out.println(s);
    System.out.println((int)s.charAt(i));
}
byte[] b= new byte[]{(byte)219};
p(new String(b, "Windows-1250"));
p(new String(b, "Windows-1251"));
p(new String(b, "Windows-1252"));
p(new String(b, "Windows-1253"));
p(new String(b, "UTF-8"));