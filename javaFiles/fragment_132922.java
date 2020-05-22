class MyClass {

}
class MyExtendedClass extends MyClass {

}
public void test() {
    Map<Integer, MyClass> myMap = new HashMap<Integer, MyClass>();
    myMap.put(1, new MyClass());
    myMap.put(2, new MyExtendedClass());
}