if(a>0 && b>0 && c>0 && d>0)
  {
    if ((a==c) ||(b==d))
    {
        if ((a==b) && (b==c) && (c==d))
        {
            System.out.println("square");
        }
        else if ( (a!=b) && (c!=d)  && ( a== c) && (b == d))
        {
            System.out.println("rectangle");
        }
        else{
            System.out.println("Two side are same but not square or rectangle");
        }
    }  
    else 
       System.out.println("four different sides");

 } else 
    System.out.println("Error");