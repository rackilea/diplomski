SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssXXX");
try {
    System.out.println(sdf.parse(date));
} catch (ParseException e) {
    e.printStackTrace();
}