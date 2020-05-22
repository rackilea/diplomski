Foo foo = new Foo();
Field f = foo.getClass().getDeclaredField("bar");
f.setAccessible(true);
Bar bar = (Bar) f.get(foo);
// or 'Object bar = f.get(foo);'
Field f2 = f.getType().getDeclaredField("name");
f2.setAccessible(true);
f2.set(bar, "hello world");