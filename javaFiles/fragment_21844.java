MyClass obj1 = null;

List<MyClass> testList = new ArrayList<MyClass>();

testList.add(obj1);//after this line of code, testList will have a "null" at first node

obj1 = new MyClass();

testList.set(0, obj1);