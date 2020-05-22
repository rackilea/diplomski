String[] a = {"Hello"};
String[] b = {"World"};
String[] c = new String[a.length+b.length];
System.arraycopy(a, 0, c, 0, a.length);
System.arraycopy(b, 0, c, a.length, b.length);
System.out.println(Arrays.toString(c));