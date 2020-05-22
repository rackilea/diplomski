String a = "The Godfather"
String b = "the godfather"
String c = "The Godfather"
String d = "thE GoDfaTher"
System.out.println(a.equalsIgnoreCase(b)); // Outputs true
System.out.println(a.equalsIgnoreCase(c)); // Outputs true
System.out.println(a.equalsIgnoreCase(d)); // Outputs true
System.out.println(a.equals(b)); // Outputs false