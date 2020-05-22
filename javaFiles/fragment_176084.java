public PatientList clone() {
 PatientList copy;
 PatientNode current;
 PatientNode copyCurrent;
 PatientNode newNode;

 copy = new PatientList();
 current = head;
 copyCurrent = null;
 while (current != null) {
  newNode = new PatientNode(current.data, null);
  if (copyCurrent == null) {
   copy.head = newNode;
  } else {
   // last node in copy points to the new node
     copyCurrent.next = newNode;
  }
 // move to the next node in both lists
  copyCurrent = newNode;
  current = current.next;
}
 copy.lastArrival = lastArrival;
 copy.size = size; // had to add this line

 return copy;
}