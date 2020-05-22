Scanner sc = new Scanner(new File(...));
while (sc.hasNext()) {
  String letter = sc.next();
  String morse = sc.next();
  findTheNode (theBinaryTree, letter, morse);
  }
  forPostion.setRootElement(letter);
}

findTheNode (BinaryTree node, String letter, String morse) {
  if (morse.length() == 0) {
    node.setRootElement(letter);
    return;
  } // found

  if (morse.charAt(0) == '.') {
    if (node.getLeft() == NULL) {
      node.setLeft() = new BinaryTree();
    }
    findTheNode (node.getLeft(), letter, morse.substring(1));
  }
  else {
    // similar
  }   
}