...
Field barField = foo.getClass().getDeclaredField("bar");
// mark the variable 'bar' as accessible
barField.setAccessible(true);
// attempt to access the value of 'bar' which will throw an exception
System.out.println(barField.get(foo));
...