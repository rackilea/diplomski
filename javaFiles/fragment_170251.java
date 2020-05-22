public static void main(String[] args) throws Exception {
    ArrayList<Integer> l = new ArrayList<Integer>();
    l.add(10);
    l.add(20);
    l.add(30);
    l.add(40);
    l.add(50);
    LinkedBlockingQueue<Integer> foo = new LinkedBlockingQueue<Integer>(3);
    foo.add(1);
    foo.add(2);
    foo.addAll(l);
}