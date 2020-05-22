class node {
    public node head;
    public node left;
    public node right;
    public node up;
    public node down;

    public node clone() {
        final node clonedNode = new node();
        node.head = this.head;
        node.left = this.left;
        node.right = this.right;
        node.up = this.up;
        node.down = this.down;
    }
}


for (int n = 1; n < 200; n++) {
    OriginalArrayOfNode[n] = OriginalArrayOfNode[m].clone(); }