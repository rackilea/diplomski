public double sum(Node root) {      
  double leftSum, rightSum, totalSum;

  if (root == null) {
   totalSum = 0;
   return totalSum;
  }else {
   leftSum = sum(root.left);
   rightSum = sum(root.right);
   totalSum = root.val + leftSum + rightSum;
   return totalSum;
  }
}