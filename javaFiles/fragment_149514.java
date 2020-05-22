while(startNode!=null){
   if(counter>=fromIndex && counter<=toIndex){ //infinite loop happens here
       Node<L> nl = new Node<L>();
       nl.data = startNode.data;
       n.add(nl);
    }
    startNode=startNode.next;
    counter++;
}