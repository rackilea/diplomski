static LinkedListNode getSum(LinkedListNode a, LinkedListNode b) {  
  //some checks first if any computation will be needed at all
  if(a == null) {
    if(b == null)
      return null;
    else
      return b;
  } else if (b == null)
    return a;

  //initialize the variables
  LinkedListNode stacka = null; 
  LinkedListNode stackb = null;
  LinkedListNode ans = null;
  LinkedListNode temp = null;

  //move the contents of a & b into stacka & stackb respectively at the same time
  //best case is when a & b are of equal size
  //worst case is when the size of a & b are worlds apart.
  while(a != null || b != null){
    if(a != null) {
      if(stacka == null){
        stacka = new LinkedListNode(a.value);
      } else {
        temp = new LinkedListNode(a.value);
        temp.next = stacka;
        stacka = temp;
      }
    }

    if(b != null) {
      if(stackb == null){
        stackb = new LinkedListNode(b.value);
      } else {
        temp = new LinkedListNode(b.value);
        temp.next = stackb;
        stackb = temp;
      }
    }

    if(a != null) a = a.next;
    if(b != null) b = b.next;
  }

  int remainder = 0;
  //just pop off the stack then merge! also, don't forget the remainder~
  while(stacka != null || stackb != null){
    //pop from the top of the stack
    int i = ((stacka == null) ? 0 : stacka.value) + ((stackb == null) ? 0 : stackb.value) + remainder;

    //set the value of the remainder if any as well as the value of i
    remainder = i / 10;
    i %= 10;

    temp = new LinkedListNode(i);
    if(ans == null) {
      ans  = temp;
    } else {
      temp.next = ans;
      ans = temp;
    }
    if(stacka != null) stacka = stacka.next;
    if(stackb != null) stackb = stackb.next;
  }
  return ans;
}