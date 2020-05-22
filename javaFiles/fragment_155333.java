deleteNodeByValue(int val) {
  if (head.val = val) {
    head = head.next
    return
  }
  current = head
  while (current.next != null) {
    if (current.next.val = val) {
      current.next = current.next.next
      return
    }
    current = current.next
  } 
}