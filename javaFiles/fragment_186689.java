if (firstNode == null) {//if empty list then straight away assign
     firstNode = newNode;
} else {
     if (newNode.getPriority() < firstNode.getPriority()) {
          newNode.next = firstNode;
          firstNode = newNode;
     } else {
         Node current = firstNode;
         while (current.getNext() != null && newNode.getPriority() >= current.getNext().getPriority()) 
             current = current.getNext();
         } 
         newNode.setNext(current.getNext());
         current.setNext(newNode); 
     }
}