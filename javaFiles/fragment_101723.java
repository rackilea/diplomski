public static String someMethod(String a, String b){return a+b;}
...

if(obj instanceof String) 
    String s = someMethod(s = "foo", s);
// we are "using" value of s here ---^