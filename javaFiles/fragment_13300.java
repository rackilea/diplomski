SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM");
Date start = sdf.parse("2010.01");
Date end = sdf.parse("2010.04");

GregorianCalendar gcal = new GregorianCalendar();
gcal.setTime(start);

while (!gcal.getTime().after(end)) {
    Date d = gcal.getTime();
    System.out.println(d);
    gcal.add(Calendar.MONTH, 1);
}