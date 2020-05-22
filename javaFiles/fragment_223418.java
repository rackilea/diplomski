public boolean equals(Object o) {  // perfectionists will make this final
  if (this == o)
     return true;
  if (o instanceof Foo) {  // note that Foo, FooA and FooB would all pass
     Foo oFoo = (Foo)o;
     // compare all the fields of Foo here
  }

  return false;
}