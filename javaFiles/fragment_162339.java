class Node {
    int factor;
    int exponent;
    Node next;

    public Node() {
        factor = 0;
        exponent = 0;
        next = null;
    }

    public Node(int factor, int exponent, Node next) {
        this.factor = factor;
        this.exponent = exponent;
        this.next = next;
    }

    public String toString() {
        return String.format("%+4dx^%d    ", new Integer[] { new Integer(factor), new Integer(exponent) }); 
    }
 }