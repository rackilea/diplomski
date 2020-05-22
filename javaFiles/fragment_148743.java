public void insertNode(Node r, Node n)
{
    if(r == null)
    {
        System.out.println("r=n"+ n.data);
        r = n; //you overwrite the value of r but never use it
    }