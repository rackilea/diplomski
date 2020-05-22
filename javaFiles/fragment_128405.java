boolean b1, b2;

if(n1.left != null && n2.left != null)
    b1 = compareTrees(n1.left, n2.left);

if(n1.right != null && n2.right != null)
    b2 = compareTrees(n1.right, n2.right);

return b1 && b2;