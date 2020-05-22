String str1 = "Ab.CD, Ab.CD";
String str2 = "F'b-CFgD., F'b-CFgD.";
String str3 = "F'b-CF gD, F'b-CF gD";

System.out.println(str1.matches("([a-zA-Z.'-]+),[ ]*([a-zA-Z.'-]+)"));  // true
System.out.println(str2.matches("([a-zA-Z.'-]+),[ ]*([a-zA-Z.'-]+)"));  // true
System.out.println(str3.matches("([a-zA-Z.'-]+),[ ]*([a-zA-Z.'-]+)"));   //false