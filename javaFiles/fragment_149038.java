public static void main(String[] args) {
Pattern pattern = Pattern.compile ("(?:https?://)?(?:[-a-zA-Z0-9_]+\\.)*[-a-zA-Z0-9_]*[-a-zA-Z_][-a-zA-Z0-9_]*(?:\\.[-a-zA-Z0-9_]+)*");

System.out.println(pattern.matcher("127.0.0.1").matches()); // false
System.out.println(pattern.matcher("1.0.0.127.in-addr.arpa").matches()); // true
System.out.println(pattern.matcher("localhost").matches()); // true
System.out.println(pattern.matcher("1-2-3-4").matches()); // true
System.out.println(pattern.matcher("http://1.0.0.127").matches()); // false
System.out.println(pattern.matcher("https://1.0.0.127").matches()); // false
System.out.println(pattern.matcher("ftp://1.0.0.127.in-addr.arpa").matches()); // false
System.out.println(pattern.matcher("http://1.0.0.127.in-addr.arpa").matches()); // true
System.out.println(pattern.matcher("https://1.0.0.127.in-addr.arpa").matches()); // true