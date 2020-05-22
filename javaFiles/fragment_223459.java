Date date= new Date();
    SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    sf.format(date);
    TimeZone tz = TimeZone.getTimeZone("GMT") OR TimeZone tz =  sf.getTimeZone();      
    TimeZone tz1 = TimeZone.getTimeZone("EST");     
    Date c= shiftTimeZone( date,tz,tz1);
    System.out.println("Format :   " + sf.format(c));