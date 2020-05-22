String s1 = "gramm";
String s2 = "Java is a programming langage";
if (s2.matches(".*\\w" + s1 + "\\w.*")) {
    System.out.println("MATCH");
}
else {
    System.out.println("NO MATCH");
}