Date d = ...;
Foo x = new Foo();
Foo y = new Foo();
x.setDate(d);
y.setDate(d);
d.setTime(d.getTime() + 1000L);
x.reset();