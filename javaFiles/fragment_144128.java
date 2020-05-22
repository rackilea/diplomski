Calendar calendar = Calendar.getInstance();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    String timeStamp = simpleDateFormat.format(calendar.getTime());


    try {
        date = simpleDateFormat.parse(timeStamp);
    }catch (Exception e){

    }
    simpleDateFormat.setTimeZone(TimeZone.getDefault());
    String localTime = simpleDateFormat.format(date); //this is the local time