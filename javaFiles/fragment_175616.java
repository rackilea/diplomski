String a = "James May";
String[] b = a.split(" ");
String c = b[0].charAt(0) + ". ";
for (int i = 1; i < b.length; i++) {
    c += b[i] + " ";
}
System.out.println(c);