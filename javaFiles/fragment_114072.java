if(input.equals("")||input.length==1)
    {
       System.out.println("un"); 
    }

    else if(input.substring(0,2).equalsIgnoreCase("un"))
    {
        System.out.println(input);
    }
    else
    {
        System.out.println("un" + input);
    }