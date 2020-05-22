// sample input
String s1 = "this.is:an-example:3.0.3";

// `s2` contains the desired output
int idx = s1.lastIndexOf(':') + 1;
String s2 = s1.substring(0, idx).replace('.', '/').replace(':', '/') + s1.substring(idx);

// now we test it
System.out.println(s2);
=> this/is/an-example/3.0.3