public void insertAscending(int data)
{
    Node node = new Node();
    node.data = data;

    if (head == null) {
        head = node;
        return;
    } else if (node.data < head.data) {
        node.link = head;
        head = node;
        return;
    }
    Node p = head;

    boolean added=false;
    while (p.link != null)
    {
        if (p.link.data > data)
        { 
           node.link = p.link;
           p.link = node;
           added = true;
           break;
        }
        p = p.link;
    }
    if (!added) 
        p.link = node;
}