public Object cast(Object object, String typeToCastTo) {
  switch (typeToCastTo) {
   case "foo":
     return Foo.class.cast(object);
   case "otherType":
     return OtherType.class.cast(object);
  }
}