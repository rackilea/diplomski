public Node {
  int data:
  Node left;
  Node right;
}


int countChildren(Node head) {
    if(head==null) return 0;
    return ((head.left == null) ? 0 : countChildren(head.left) + 1) + ((head.right == null) ? 0 : countChildren(head.right) + 1);
}