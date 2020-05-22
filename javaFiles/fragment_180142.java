public double  getLength()
 {
    if(dataRight==false)
    {
       System.out.printf("\nAs wrong data, calculation Not possible.\n ");
       return 0.0; //<-- Return path must exist for all possible paths in a method, you could also add exception handling
    }
    else
       return length;
 }