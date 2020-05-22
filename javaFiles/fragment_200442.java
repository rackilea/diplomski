public void reverse(LinkedList<E> a) {
    LinkedList<E> list = new LinkedList<E>(a);

    System.out.println(list.getLast());

    list.removeLast();

    if(list.size() > 0) {
        reverse(list);
    }
}