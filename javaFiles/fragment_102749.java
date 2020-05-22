GregorianCalendar c = new GregorianCalendar();
TimeZone tz = c.getTimeZone();
System.out.println(tz);

int tzo = tz.getOffset(date.getTime());
System.out.println(
      tzo/3600000 + ":" + 
      (tzo/60000)%60 + ":" + 
      (tzo/1000)%60 + "." + 
      tzo%1000);