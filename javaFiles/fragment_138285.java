@Test
   public void testListSize() {

    LinkedList <String> linkedlist = new LinkedList<String>();
    linkedlist.add("Item 0");
    linkedlist.add("Item 1");
    linkedlist.add("Item 2");
    linkedlist.add("Item 3");
    linkedlist.add("Item 4");
    linkedlist.add("Item 5");
    linkedlist.add("Item 6");
    linkedlist.add("Item 7");
    linkedlist.add("Item 8");
    linkedlist.add("Item 9");

    Pruner prunes = new Pruner();
    prunes.prune(linkedlist, 2);

    assertThat(linkedlist.size(), is(5));
    assertThat(linkedlist, hasItem("Item 1"));    
  }