String msg = ... ; 
String key = ... ;
StringBuilder sb = new StringBuilder(msg.length());
for (int i = 0; i < msg.length(); i++) {
  sb.append((char)(msg.charAt(i) ^ key.charAt(i % key.length())));
}