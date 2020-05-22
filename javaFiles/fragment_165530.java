long millis = 1568814839L;
System.out.println(millis); //1568814839
Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tashkent"));
System.out.println(calendar.getTimeInMillis()); //1568820981321
calendar.setTimeInMillis(millis);
System.out.println(calendar.get(Calendar.YEAR));//839