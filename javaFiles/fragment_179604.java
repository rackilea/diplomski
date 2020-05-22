...
byte[] digest = md.digest();
StringBuffer sb = new StringBuffer();
for (int i = 0; i < digest.length; i++) {
    String hex = Integer.toHexString(0xff & digest[i]);
    if (hex.length() == 1) sb.append('0');
    sb.append(hex);
}
System.out.println(sb.toString());