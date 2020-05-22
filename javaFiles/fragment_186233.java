Long x = 100, y = 100;
System.out.println(x == y); // true, references are the same.

Long a = 200, b = 200; // values not cached.
System.out.println(a == b); // false, references are not the same.
System.out.println(a.equals(b)); // true, the objects referenced are equal