Date date=new Date();
    Calendar calendar = Calendar.getInstance();
    date=calendar.getTime(); 
    SimpleDateFormat s;
    s=new SimpleDateFormat("MM/dd/yy");

    System.out.println(s.format(date));

    int days = 5;
    for(int i=0;i<days;)
    {
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        //here even sat and sun are added
        //but at the end it goes to the correct week day.
        //because i is only increased if it is week day
        if(calendar.get(Calendar.DAY_OF_WEEK)<=5)
        {
            i++;
        }

    }
    date=calendar.getTime(); 
    s=new SimpleDateFormat("MMM dd, yyyy");
    System.out.println(s.format(date));