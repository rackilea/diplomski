Integer a = new Integer(50);
Integer b = new Integer(50);
System.out.println(a == b); // prints false, because a and b refer to different objects

Integer c = b;
System.out.println(b == c); // prints true, because b and c refer to the same object