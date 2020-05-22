// these two types are unrelated
class Foo {}
class Bar {}

// ...
Foo f = new Foo();
Bar b = (Bar)f; // fails to compile