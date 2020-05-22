SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

Date date1 = format.parse(date1);
Date date2 = format.parse(date2);

if (date1.compareTo(date2) <= 0) {
    System.out.println("earlier");
}