Integer a = new Integer(42);
Integer a = new Integer(43);

System.out.println(a < b);
// is automatically converted to
System.out.println(a.intValue() < b.intValue());