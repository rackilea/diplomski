public void split(UnorderedLinkedListInt list1, UnorderedLinkedListInt list2, int key) {

  //Replace this by what ever type is making up your lists nodes
  UnorderedLinkedListInt.Node node = this.first;

  //Check at each step if you have reached the end of the list
  while (node != null) {
    //Partition logic
    if (node.info > key)
      list1.insertFirst(node.info);
    else
      list2.insertFirst(node.info);

    //Update to the next node
    node = node.link;
  }

}