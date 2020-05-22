String s = "\n";
System.out.println(s.replaceAll("\n", "LF")); // => LF
System.out.println(s.replaceAll("\\n", "LF")); // => LF
System.out.println(s.replaceAll("(?x)\\n", "LF")); // => LF
System.out.println(s.replaceAll("(?x)\\\n", "LF")); // => LF
System.out.println(s.replaceAll("(?x)\n", "<LF>")); 
// => <LF>
//<LF>