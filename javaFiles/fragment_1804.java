String startDaystr = startDay.getText().toString();   
String startMonthtstr = startMonth.getText().toString();
String startYearstr = startYear.getText().toString();

String endDaystr = endDay.getText().toString();
String endMonthstr = endMonth.getText().toString();
String endYearstr = endYear.getText().toString();


Calendar startDate = Calendar.getInstance();
startDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(startDaystr));
startDate.set(Calendar.MONTH, Integer.parseInt(startMonthtstr));
startDate.set(Calendar.YEAR, Integer.parseInt(startYearstr));
startDate.set(Calendar.HOUR_OF_DAY, 0);
startDate.set(Calendar.MINUTE, 0);
startDate.set(Calendar.SECOND, 0);

Calendar endDate = Calendar.getInstance();
endDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(endDaystr));
endDate.set(Calendar.MONTH, Integer.parseInt(endMonthstr));
endDate.set(Calendar.YEAR, Integer.parseInt(endYearstr));
endDate.set(Calendar.HOUR_OF_DAY, 0);
endDate.set(Calendar.MINUTE, 0);
endDate.set(Calendar.SECOND, 0);

long diff = endDate.getTimeInMillis() - startDate.getTimeInMillis();
long dayCount =  diff / (24 * 60 * 60 * 1000);