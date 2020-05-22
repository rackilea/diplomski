SomeClass obj = new SomeClass();

SomeClass.staticPrint(); // prints "Hello from static"
SomeClass.instancePrint(); // throws an error

obj.staticPrint(); // throws an error
obj.instancePrint(); // prints "Hello from non-static"