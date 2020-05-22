class MyClass {
    <T> T method(List<? extends T> list1, List<? super T> list2) {
        return list1.get(0); // Valid
        //return list2.get(0); // Invalid Type mismatch: cannot convert from capture#1-of ? super T to T
    }
}

List<Integer> listIntegers = new ArrayList<Integer>();
listIntegers.add(1);

List<String> listObjects = new ArrayList<String>();
listObjects.add("2");

MyClass mcls = new MyClass();

// Valid
Integer result=mcls.method(listIntegers, listObjects);

// Invalid
String result=mcls.method(listIntegers, listObjects);
// The method method(List<? extends T>, List<? super T>) in the type MyClass is not applicable for the arguments (List<Integer>, List<String>)