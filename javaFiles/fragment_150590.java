String s= new String("abc");
    final String lm = "abc";

    switch(s)
    {
       case lm:
           case "abc": //This is more precise as per the comments
           System.out.println("hi");
           break;
    }