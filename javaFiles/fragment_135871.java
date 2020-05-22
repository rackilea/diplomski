SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");      
    long Start1 =sdf.parse("14-08-2014").getTime();
    long End1=sdf.parse("14-08-2015").getTime();
    long Start2=sdf.parse("14-08-2012").getTime();
    long End2=sdf.parse("14-08-2013").getTime();
    System.out.println("overlapped :" +!((Start1>End2)||(End1<Start2)));