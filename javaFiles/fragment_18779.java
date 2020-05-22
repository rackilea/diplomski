BaseClass o = BaseFactory.create(BaseClass.class);
BaseClass o = BaseFactory.create(ClassA.class);
BaseClass o = BaseFactory.create(ClassAA.class);
BaseClass o = BaseFactory.create(ClassB.class);

Class<? extends BaseClass> c = String.class; // this will not compile
BaseClass o = BaseFactory.create(String.class); // this will not compile