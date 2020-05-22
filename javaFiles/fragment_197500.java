String str = "Fri, 25 Sep 2015 12:01:16 +0000";
SimpleDateFormat sdf = new SimpleDateFormat("E, d MMM y H:m:s X");
try {
    System.out.println(sdf.parse(str));
} catch (ParseException e) {
    e.printStackTrace();
}