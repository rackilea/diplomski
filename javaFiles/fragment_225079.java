List containerResults = query.List(); 

    for(Object[] result : containerResults) 
    {
       Integer id = (Integer) result[0];
       Date date = (Date) result[1];
       String notes = (String) result[2];
    }