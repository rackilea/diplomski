void search(int item, Node root, int r, int c) {
    if (root != null) {
       if (root.val == item) {
           System.out.println("integer located at row: " + r + " & child: " + c + "\n");
       } else if (item < root.val) {
            search(item, root.left, r + 1, (c * 2) - 1);
       } else {
            search(item, root.right, r + 1, c * 2);
       }
    } else {
       System.out.println("integer cannot be located\n");
    }
 }