Node head = new Node(1);
Node tempPtr = head;

while ( tempPtr.getMyInt() <= 10 )
{
    tempPtr.addNode(new Node(tempPtr.getMyInt()+1));
    tempPtr = tempPtr.nextNode();
}