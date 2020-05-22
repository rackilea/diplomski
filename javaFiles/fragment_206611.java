public class TestSortTree {
    @Test
    public void test() {
        Node node = new Node(1);
        Node left = new Node(2);
        Node leftLeft = new Node(22);
        Node leftRight = new Node(23);
        Node leftRightLeft = new Node(24);
        left.setLeft(leftLeft);
        leftRight.setLeft(new Node(39));
        left.setRight(leftRight);
        node.setLeft(left);
        node.setRight(new Node(3));
        System.out.println(node.toString());
    }
}