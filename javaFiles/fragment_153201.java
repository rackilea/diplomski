public class Main
{
    public static void main(String[] args) {
        IList list1 = new ConsList(new Node(1),
            new ConsList(new Node(2),
            new ConsList(new Node(3),
            new ConsList(new Node(4),
            new EmptyList()))));

        IList list2 = new EmptyList();

        System.out.println(list1.getNodeNumbers() + " - " + list2.getNodeNumbers());
    }
}