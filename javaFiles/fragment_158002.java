private Node(Station data, Node next) {
         this.data = data;
         this.next = next;  
     } 

     private Station getData() {
         return data;
     } 

     private void setData(Station data) {
         this.data = data;
     } 

     private Node getNextNode() {
         return next;
     } 

     private void setNextNode(Node next) {
         this.next = next;
     }