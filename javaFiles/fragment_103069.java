boolean hasCycle(Node head) {
   HashMap<Node,Integer> map = new HashMap<Node,Integer>();
   if(head == null || head.next == null)
      return false;
   Node p = head;
   while(p.next!=null) {
      if (map.containsKey(p.next)) {
         return true;
      } else {
         map.put(p.next,p.data);
      }
      p = p.next;
    }
    return false;
}