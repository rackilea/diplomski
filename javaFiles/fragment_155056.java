final Iterator<Foo> iterator = someInstanceImplementingIterableOfFoo.iterator();

Foo foo;

while (iterator.hasNext()) {
    foo = iterator.next();
    doSomethingWith(foo);
}