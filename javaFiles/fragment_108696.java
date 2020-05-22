private Foo(){
}

public static Foo ofTrue(String valueForTrue){
   Foo foo = new Foo();
   foo.valueForTrue = valueForTrue;
   return foo;
}

public static Foo ofFalse(String valueForFalse){
   Foo foo = new Foo();
   foo.valueForFalse = valueForFalse;
   return foo;
}

public static Foo of(String valueForTrue, Sting valueForFalse){
   Foo foo = new Foo();
   foo.valueForTrue = valueForTrue;
   foo.valueForFalse = valueForFalse;
   return foo;
}