Field m = String.class.getDeclaredField("value");
m.setAccessible(true);
MethodHandle mh = MethodHandles.publicLookup().unreflectGetter(m);
char[] ch = (char[])mh.invoke("hello");
Arrays.fill(ch, '*');
System.out.println("hello");