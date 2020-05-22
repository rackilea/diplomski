String formats[] =
     {"dd/MM/yyyy HH:mm:ss.SS"}; //and more depending on your need
     Timestamp ts = null;
     for (int i = 0; i < formats.length; i++) 
     {
     SimpleDateFormat sdf = new SimpleDateFormat(formats[i]);
     try {
         java.util.Date date = sdf.parse(stringValue);
         ts = new Timestamp(date.getTime());
         return ts;
     }
     catch( ParseException e) {
    }