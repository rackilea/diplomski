public class Nulls {

    static Node node;

    private class Node {
        int val;
        Node right;
        Node left;
    }

    public void init() {
        if(node==null) {
            node=new Node();
        }
    }

    public void print() {
        System.out.println(node);
    }

    public static void main(String[] args) {
        Nulls n=new Nulls();
        n.init();
        n.print();
    }
}