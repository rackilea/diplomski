public static void main(String[] args) {

    OrderedLinkedList list = new OrderedLinkedList();
    OrderedLinkedList removedList = new OrderedLinkedList();

    modCount = 0;
    list.add("Dog");
    list.add("Bird");
    list.add("dog");
    list.add("bird");
    list.add("Cat");
    System.out.println("Before removal of element");
    System.out.println(list);

    // list.remove("Dog"); // not needed anymore
    // removedList.add("Dog"); //not what I'm wanting to do

    // pop returns the removed object
    removedList.add(list.pop("Dog"));

    System.out.println("Removed " + removedList);
    System.out.println("After removal of element");
    System.out.println(list);
    System.out.println("Total modifications = " + modCount);
    System.out.println();
}