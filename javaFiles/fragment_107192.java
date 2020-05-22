public void addAtEnd(String s) {
  Node current = head;
  Node newNode = new Node(s);
   if(head == null) {
     head = newNode;
     head.setNext(null);
   } 
   else {// problem is here. You need to find the  node that has getNext()==null, 
         //so you need to loop all nodes where get next != null
     while(current.getNext() == null) { 
       current.setNext(newNode);
       current = newNode;
   } 
 }