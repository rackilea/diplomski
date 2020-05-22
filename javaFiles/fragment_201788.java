public void push(String item){
    Node old_first = first; //<-- the initial null is preserved here
    first = new Node();
    first.str = item;
    first.next = old_first.next; //<-- you attempt to use the preserved null here
    //first = node;
    count++;
}