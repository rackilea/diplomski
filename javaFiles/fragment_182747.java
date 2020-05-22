UUID a = new UUID(12345678, 87654321);
UUID b = new UUID(12345678, 87654321);
UUID c = new UUID(11111111, 22222222);

System.out.println(a == a); // returns true
System.out.println(a.equals(a)); // returns true

System.out.println(a == b); // returns false
System.out.println(a.equals(b)); // returns true

System.out.println(a == c); // returns false
System.out.println(a.equals(c)); // returns false