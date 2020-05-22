Calendar calender = Calendar.getInstance();
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

String timeStamp = formatter.format(calender.getTime());
Date strDate = formatter.parse(timeStamp);

String currentTimeStamp = formatter.format(new Date());
Date currentTime = formatter.parse(currentTimeStamp);

if (currentTime.after(strDate)) {

}