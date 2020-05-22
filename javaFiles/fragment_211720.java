static ListNode ReverseLinkedList(ListNode headNode)
{
    ListNode headNodeTemp = headNode;
    ListNode tempNode = headNode.getNext();
    headNodeTemp.setNext(null);
    ListNode currentNode = headNodeTemp;
    while(tempNode != null)
    {...