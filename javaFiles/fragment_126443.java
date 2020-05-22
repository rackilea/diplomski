// First convert to date object
SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
System.out.println("dateStr: " + dateStr);

Date date = sdf.parse(dateStr);

SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
sdf2.format(date);

// Then, format it to get 2011 with another date format.
System.out.println("dateStr After: " + sdf.format(date));
System.out.println("dateStr NEXT After: " +  sdf2.format(date));