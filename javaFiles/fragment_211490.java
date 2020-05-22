class MyNode
{
  private MyNode left;
  private MyNode right;

  void iterate()
  {
    // Iterate over left part
    if (left != null)
      left.iterate();

    // Do what you want with the current node

    // Iterate over right part
    if (right != null)
      right.iterate();

  } // iterate

} // class MyNode