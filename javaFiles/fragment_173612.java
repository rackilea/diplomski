DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
     Date date = format.parse("1/1/2012");
     //Calendar cal = new GregorianCalendar();
     Calendar cal = Calendar.getInstance();
     cal.setTime(date);
     int day = cal.get(Calendar.DAY_OF_MONTH);//You may want to add 1
     int month = cal.get(Calendar.MONTH);
     int year= cal.get(Calendar.YEAR);