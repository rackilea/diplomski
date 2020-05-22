public static String docat(String f, String s) {
   if (!f.contains(s.substring(0,1)))
     return f + s;
   int idx = s.length();
   try {
     while (!f.endsWith(s.substring(0, idx--))) ;
   } catch (Exception e) { }
   return f + s.substring(idx + 1);
 }

 docat("Some little d", "little dogs are so pretty");
 -> "Some little dogs are so pretty"
 docat("Hello World", "World")
 -> "Hello World"
 docat("Hello", "World")
 -> "HelloWorld"