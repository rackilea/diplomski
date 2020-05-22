// fields in some class
List<Obj> list = createAndPopulateALinkedList();
Iterator<Object> iterator;

void someMethod() {
    iterator = list.iterator();
    // ...
    list.clear();
}