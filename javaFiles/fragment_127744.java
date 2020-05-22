public Node insert(Item a)
{
    length++;
    head=new Node(a, head);
    return head;
}