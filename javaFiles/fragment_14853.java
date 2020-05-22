String actualDate = m.getDate();
if (actualDate == null) {
    Calendar c = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
    String strDate = sdf.format(c.getTime());
    //Time set here
    date.setText(strDate);
}