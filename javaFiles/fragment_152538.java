public static void main(String[] args) {
    String dateString = "2014-07-23 09:00:00";
    SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
    try {
        Date date = sdf.parse(dateString);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY) + " PM") ;
    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}