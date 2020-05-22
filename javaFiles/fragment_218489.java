public String name;
    public LinkedList next;
    public LinkedList(String name)
    {
      this.name = name;
      this.next = null;
    }
    public String toString()
    {
      return name;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
          Linked l = new Linked();
          l.insert("tom");
          l.insert("joe");
          l.insert("cory");
          l.print();

        }
     }
    class Linked
    {
    LinkedList first;
    LinkedList tail;

    public Linked()//initialize 
    {
        this.first = null;
        this.tail = first;
    }

    public void insert(String name)
    {    
        LinkedList g = new Test(name);
        if(isEmpty())
        {
            first = g;
            tail = first;
        }
        else
        {
            tail.next = g;
            tail = g;
        } 
    }
     //checks if the list is empty
    public boolean isEmpty()
    {
        return (first ==null);
    }
    public void print() //displays the list
     {
        LinkedList t = first;
        while(t!=null)
        {
            System.out.println(t);
            t = t.next;
        }
}