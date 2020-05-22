public void swapNodes(int num1, int num2) {

    if (num1 == num2) {
      return;
    }

    Node node1 = null;
    Node node2 = null;

    Node cur = head;
    while(cur != null) {
      if (num1 == cur.data) {
        node1 = cur;
      }
      if (num2 == cur.data) {
        node2 = cur;
      }
      cur = cur.next;
    }

    if (node1 == null || node2 == null)
      return;

    int tmp = node1.data;
    node1.data = node2.data;
    node2.data = tmp;
  }