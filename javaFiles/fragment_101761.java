String date = "Oct 28, 2015, 05.15PM IST";
date = date.substring(0, date.length()-4);

SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy, hh.mma", Locale.US);
format.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
Date myDate = format.parse(date);