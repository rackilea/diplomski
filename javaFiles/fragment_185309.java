public void remove(T element){

    Node<T> cur = first.next;
    Node<T> prev = first;
    Node<T> nn = new Node(element);//I'm assuming you have constructors that accept data
    boolean deleted = false;

    while(cur!=null&&deleted == false){
           if(cur.data.equals(element)){
                         prev.next = cur.next;
                         this.count--;
                         deleted = true;

                     }

        }

prev = gotolastnode(prev);
prev.next = nn;
}