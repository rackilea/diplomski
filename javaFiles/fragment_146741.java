private Node deepCopy(Node original) {
    // We use the following map to associate newly created instances 
    // of Node with the instances of Node in the original list
    Map<Node, Node> map = new HashMap<Node, Node>();
    // We scan the original list and for each Node x we create a new 
    // Node y whose data is a copy of x's data, then we store the 
    // couple (x,y) in map using x as a key. Note that during this 
    // scan we set y.next and y.random to null: we'll fix them in 
    // the next scan
    Node x = original;
    while (x != null) {
        Node y = new Node();
        y.setData(new String(x.getData()));
        y.setNext(null);
        y.setRandom(null);
        map.put(x, y);
        x = x.getNext();
    }
    // Now for each Node x in the original list we have a copy y 
    // stored in our map. We scan again the original list and 
    // we set the pointers buildings the new list
    x = original;
    while (x != null) {
            // we get the node y corresponding to x from the map
        Node y = map.get(x);
            // let x' = x.next; y' = map.get(x') is the new node 
            // corresponding to x'; so we can set y.next = y'
        y.setNext(map.get(x.getNext()));
            // let x'' = x.random; y'' = map.get(x'') is the new 
            // node corresponding to x''; so we can set y.random = y''
        y.setRandom(map.get(x.getRandom()));
        x = x.getNext();
    }
    // finally we return the head of the new list, that is the Node y
    // in the map corresponding to the Node original
    return map.get(original);
}