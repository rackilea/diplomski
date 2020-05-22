private static java.sql.Timestamp getCurrentTimeStamp() {

    java.util.Date today = new java.util.Date();
    return new java.sql.Timestamp(today.getTime());

}


private static Timestamp getTimeStamp(String ts){

 //Change the format as per your requirement
  DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
  Date date = dateFormat.parse(ts));
  long time = date.getTime();
  new Timestamp(time);

}