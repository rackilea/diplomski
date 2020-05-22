Scanner sc = new Scanner(new File(...));
while (sc.hasNext()) {
  String letter = sc.next();
  String morse = sc.next();
  BinaryTree forPosition = theBinaryTree;
  for(int i = 0; i < morse.length(); i++) {
    if (morse.charAt(i) == '.') {
      if(forPosition.getLeft() == NULL) {
        forPosition.setLeft() = new BinaryTree();
      }
      forPosition = forPosition.getLeft();
    }
    else {
      // similar
    }
  }
  forPostion.setRootElement(letter);
}