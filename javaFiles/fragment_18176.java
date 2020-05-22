public class superclass
{
    public void display()
    }
        System.out.println("Display Superclass");
    }
}

public class subclass extends superclass
{
    public void display()
    {  
        System.out.println("Display Subclass");
    }
}

public class Testing
{    
   public static void main(String args[])
   {
      subclass sub = new subclass();
      superclass sup = (superclass) sub; 
      sup.display();
   }
}