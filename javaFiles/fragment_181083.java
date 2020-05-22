public class Test {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(new Node(1));
        list.add(new Node(2));
        list.add(new Node(4));
        list.add(new Node(4));
        list.add(new Node(5));
        list.print();

        list.removeSecondAppearance(4);
        list.print();
    }
}