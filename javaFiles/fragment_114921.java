public String toString(){
  Node_Graph h = head;
  String s = "";
  while(h != null){
    s += "[" + h.toString() + "] ";
    h = h.next;
  }
  return s;
}