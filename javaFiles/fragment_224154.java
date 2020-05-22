Field foo = HasPrivate.class.getDeclaredField("foo");
foo.setAccessible(true);
SteveClass steve = new SteveClass();
System.out.println(steve); // "0" -- I set up SteveClass.toString() to just print foo
foo.setInt(hp, 1234);
System.out.println(steve); // "1234"