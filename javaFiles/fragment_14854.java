String actualDate = m.getDate();
if (actualDate == null) {
    Calendar c = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
    String strDate = sdf.format(c.getTime());
    m.setDate(strDate);
}

//Time set here
date.setText(m.getDate());