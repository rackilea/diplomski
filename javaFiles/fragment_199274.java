Foo foo = fooMap.get(fooName);
if( foo == null)
{
  foo = new Foo(fooName);
  fooMap.put(fooName, foo);
}
foo.AddtoFoo(item);