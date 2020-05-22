private final String[] datePatterns = {"Yesterday","Today","Tomorrow", //etc
        "Sunday","Monday","Tuesday","Thursday","Friday", // etc
         "Lundi","Mardi","Mercredi", //etc in French
        "2001","2002", // all the years 
        "AM","PM",
        "January","February","March","August"};
private List lx  = new ArrayList();


public boolean mayContainDates(String toCheck)
{
toCheck = toCheck.toUpperCase();

// irl we'd build this list 1 time in the constructor
for(int i = 0; i < datePatterns.length; i++)
{
lx.add(datePatterns[i].toUpperCase()); 
}

   Iterator lit = lx.iterator();

    while(lit.hasNext())
    {    
    if (toCheck.contains((String) lit.next())
    {
    return true;
    }
    }

    return false;
}