SimpleDateFormat format = new SimpleDateFormat("HH:mm");
Date date2 = format.parse(time2);

Calendar cal=Calendar.getInstance();
cal.setTime(date2);
cal.add(Calendar.MINUTE, -30); //Subtract 30 Min

String strLong= format.format(cal.getTime());
textView4.setText(strLong);