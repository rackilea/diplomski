public void insert(int data) {
   if (root == null) {
      root = new AVLNode(data);
   } else {
      AVLNode node = root;
      AVLNode newNode = new AVLNode(data);
      while (node != null) {
         if (node.data <= data) {
            if (node.right == null) {
               node.right = newNode;
               node = null;
            } else {
               node = node.right;
            }
         } else {
            if (node.left == null) {
               node.left = newNode;
               node = null;
            } else {
               node = node.left;
            }
         }
      }
   }
}