// Create my instance
MyClass myClass = MyClass.newInstance();
// Execute some code here
...
// Release the instance once the work is over to prevent a memory leak
MyClass.release(myClass);
...
// Execute some code on all instances
// Here it will print all instances
MyClass.apply(System.out::println);
...
// Release all instances that match with a given test
MyClass.releaseAll(myClass -> <Some Test Here>);