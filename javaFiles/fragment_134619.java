String strDate = "2011-11-06T14:34:16.679+02:00";
strDate = strDate.substring(0, 26) + strDate.substring(27, 29);

String pattern = "yyyy-MM-dd'T'hh:mm:ss.SSSZ";
SimpleDateFormat sdFormat = new SimpleDateFormat(pattern);

Date d = sdFormat.parse(strDate);