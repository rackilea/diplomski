String formats[] =
     {"dd/MM/yyyy"};  //and more depending on your need
     for (int i = 0; i < formats.length; i++) 
     {
     SimpleDateFormat sdf = new SimpleDateFormat(formats[i]);

     try {

     java.util.Date date = sdf.parse(stringValue);
     java.sql.Date datesql = new java.sql.Date(date.getTime());
     return datesql;
     }
     catch( ParseException e) {
     }
     }