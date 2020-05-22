while(sc.hasNext())
   {
    name= sc.next(); //get each line from text file
    String [] Str=name.split(",");
    if(Arrays.asList(Str).contains(Name))//check whether Name contains or not
    System.out.println("Yes");//If array contains the given input then Yes
    else
    System.out.println("No");//Otherwise No
    }