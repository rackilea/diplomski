// TODO: Don't use double here - it's completely inappropriate. Use
// BigDecimal if you absolutely must, but preferrably use a time-related
// type, e.g. something from Joda Time (http://joda-time.sf.net)
double parsedStart = Double.parseDouble(finalStart.substring(0, 5)
                                                  .replace(':', '.'));

// TODO: Put all of these constants in a HashSet<String> and use contains
if (room.equals("FEB 2009") || 
    room.equals("FEB 2011") ||
    room.equals("FEB 2013") || 
    room.equals("FEB 2015") || 
    room.equals("FEB 2017") ||
    room.equals("FEB 2021") || 
    room.equals("FEB 2023") || 
    room.equals("FEB 2025") || 
    room.equals("FEB 2027") || 
    room.equals("FEB 2029")) {

    instanceNum = 4;
    devID = 130200;
    // TODO: Change to if (!ac101Flag)
    if (ac101Flag == false) {
        // TODO: Rename these methods to follow Java naming conventions
        Delete();
        Insert();
        ac101Flag = true;
        tempAC101Start = parsedStart;
        tempAC101End = parsedEnd;
    }
    //Insert();
    else if (tempAC101Start <= parsedStart && tempAC101End >= parsedEnd) {

    }
    else
    {
        Insert();
        tempAC101Start = parsedStart;
        tempAC101End = parsedEnd;
    }   
}