while(fileScan.hasNext())
    {
        String token= fileScan.next();
        if(token.equals("Firstname: "))
        {
            firstname = fileScan.next();
        }
        else if(token.equals("Lastname: "))
        {
            lastname = fileScan.next();
        }
        else if(token.equals("Postalcode: "))
        {
            postalcode = fileScan.next();
        }
    }
    for(Person info : person)
    {
        System.out.println(info);
    }