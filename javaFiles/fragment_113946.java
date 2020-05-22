SimpleDateFormat sdf=new SimpleDateFormat();
sdf.applyPattern("YYYY");
Date d=null;
try {
    d = sdf.parse("1999");
} catch (ParseException e) {
    e.printStackTrace();
}
System.out.println(d);