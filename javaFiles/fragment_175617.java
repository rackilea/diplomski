String a = "James May, Jack Jones, Jaime Martinez";
String[] b = a.split(", ");
String c = b[0].replaceFirst("(?<=^.)\\S+", "."); 
for(int i = 1; i < b.length; i++) {
c += ", " + b[i].replaceFirst("(?<=^.)\\S+", ".");
}
System.out.println(c);