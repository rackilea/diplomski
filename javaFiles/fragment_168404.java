while(sc.hasNext())
   {
    name= sc.next();   
    String [] Str=name.split(",");
    for(String s: Str){
    if (Name.equals(s))
    {
        System.out.println("Yes");
    }       
    else
    {
        System.out.println("No");
    }
    }//for missed. otherwise it will check only the first word in the String array
    }