LinkedList list = new LinkedList();
list.add("foo");
list.add("bar");
list.add("baz");
list.add("etc");
BinarySearchTree bst = new BinarySearchTree(); 
for(Object o:list) {
    bst.add(o);
}