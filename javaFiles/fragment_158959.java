DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    dateFormat.setCalendar(new GregorianCalendar());
    Date d=dateFormat.parse("1700-00-00");
    System.out.println(d);
    d=dateFormat.parse("1700-01-01");        
    System.out.println(d);
    d=dateFormat.parse("1700-13-01");        
    System.out.println(d);