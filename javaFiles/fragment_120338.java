public static void main(String[] args) {

    List<A> myList = new ArrayList<>();

    A object1 = new A();
    B object2 = new B();
    C object3 = new C();

    myList.add(object1);
    myList.add(object2);
    myList.add(object3);

    for (A object : myList) {
        object.methodFromA();

        if (object instanceof B) {
            B castedObject = (B) object;
            castedObject.methodFromB();
        }
        else if (object instanceof C) {
            C castedObject = (C) object;
            castedObject.methodFromC();
        }
    }
}