class MyLinkedList 
{
   private class Node           
   {
        private Node link;
        private int x;
   }
    //----------------------------------
    private Node first = null;    
    private Node last = null;    
    //----------------------------------

    public void addFirst(int d)
    {
        Node newNode = new Node(); 
        newNode.x = d;            
        newNode.link = first;      
        first = newNode;
        if(last == null)
            last = newNode;           
    } 

    public void addLast(int q)
    {
        Node newNode = new Node();
        newNode.x = q;
        newNode.link = null;  //points to null because nothing should follow it
        if(last != null)
            last.link = newNode;
        last = newNode;
        if(first == null) // This is the first node
            first = newNode;
    }

    //----------------------------------
    public void traverse()
    {
        Node p = first;
        while (p != null)            
        {
            System.out.println(p.x);  
            p = p.link;               
        }
    }

    public int getLast()
    {
        if(last != null)
            return last.q;
        return -1;
    }
}