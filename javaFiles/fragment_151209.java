public void preorder() {
    if (leaf == null && right == null) 
      System.out.println(value);
    else {
      System.out.println("(");
      System.out.println(value);
      if(left != null) left.preorder();
      if(right != null) right.preorder();
      System.out.println(")");
    }
  }