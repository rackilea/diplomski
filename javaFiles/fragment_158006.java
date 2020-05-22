FooClassEnum classEnum = FooClassEnum.get("foo1");
Class classOfYourJson = classEnum.getFooClass();
//Cast your object
Object yourObj;
if(classOfYourJson.newInstance() instanceof Foo1) {
    Foo1 f1 = (Foo1) yourObj;
} else if(classOfYourJson.newInstance() instanceof Foo2) {
    Foo2 f2 = (Foo2) yourObj;
} else if(classOfYourJson.newInstance() instanceof Foo3) {
    Foo3 f3 = (Foo3) yourObj;
} else {
   //error
}