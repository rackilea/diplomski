(1) get today's date or get your db date
Date today = Calendar.getInstance().getTime();

// (2) create a date "formatter" (the date format we want)
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");

// (3) create a new String using the date format we want
String folderName = formatter.format(today);