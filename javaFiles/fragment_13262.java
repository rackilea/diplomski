public static void main(String[] ar) {
    LinkedList<Integer> l = new LinkedList<Integer>();

    l.add(1);
    l.add(2);
    l.add(3);

    Iterator<Integer> i1 = l.iterator();

    System.out.println(i1.next());
    System.out.println(i1.next());

    // Here we modify the content of "l"
    l.add(4);

    // After modifying the content of "l" we try to get the next element of the iterator: this will throw an exception
    System.out.println(i1.next());
}