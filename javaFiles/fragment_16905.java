public void reverseDisplay(){       
  Node currentNode = head;
  String out = "";

  while(currentNode != null){

    out = currentNode.getItem() + " " + out; // instead of out + currentNode.getItem() + " ";
    currentNode = currentNode.getNext();

  }
  System.out.println(out);
}