public void insertq(int data) {
    if(root == null) {
      root = new Node(data);
    } else {
      temp = root;
      while (temp.next != null) {
          temp = temp.next;
      }
      Node newNode = new Node(data);
      temp.next = newNode;
    }
  }