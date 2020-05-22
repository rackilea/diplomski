public void add(String s){
    int index = hash(s) % data.length;
    System.out.println("Adding at index: " + index);
    Element curr = new Element(s);
    Element e = this.data[index];
    if (e == null) {
       this.data[index] = curr;
       return;
    }
    while(e.getNext() != null){
        e = e.getNext();
    }
    e.setNext(curr);
}