findViewById(R.id.buttonAlarm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
    String dateInString = "26-10-2017 06:49:59";
    long alarmDate = 0L;
    try {
        Date d = sdf.parse(dateInString);
        alarmDate = d.getTime();
    } catch (ParseException e) {
        e.printStackTrace();
    }
}