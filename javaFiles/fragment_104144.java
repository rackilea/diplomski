public void detectLoop1()
{
    Node tnode = head;
    Set nodes = new HashSet();

   while (tnode != null)
    {
        System.out.print(tnode.data+"->");

        if(!nodes.add(tnode)){
            System.out.println("Found a Loop");
            break;
        }

        tnode = tnode.next;    
    }
}