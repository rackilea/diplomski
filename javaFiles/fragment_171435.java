String s1 = " 055E";
s1 = s1.trim();
byte[] b = {
    (byte) Integer.parseInt(s1.substring(0, 2), 16),
    (byte) Integer.parseInt(s1,substring(2), 16)
}