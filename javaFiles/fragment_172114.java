Object ojc = new ArrayList();
obj.add(new Object()); //Compiler error because Object does not have an add method
ArrayList lst = (ArrayList)obj;
lst.add(new Object()); //Works because now the compiler knows that the variable is an ArrayList
MyClass myClass = (MyClass)obj; //ClassCastException because the object is not actually a MyClass object
myClass.add(new Object()); //Assuming MyClass defines and add method that takes and object, this line compiles