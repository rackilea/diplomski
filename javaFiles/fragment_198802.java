String s1 = "cat";
String s2 = "";
for (int i =0 ; i < s1.length(); i++) {
   char c = s1.charAt(i);
   c += 1;

   // reverse string implementation omitted
}
System.out.println(s2);