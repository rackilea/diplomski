public boolean isLocked() {

boolean returnCode = true;
// current date & time
Calendar now = Calendar.getInstance();

// parse date & time from database
String trainingStartDate = this.getDate();

String trainingStartTime = this.getStartTime();

String strDateTime = trainingStartDate + " " + trainingStartTime;

Calendar training = Calendar.getInstance();

try {
    training.setTime(new SimpleDateFormat("MM-dd-yyyy HH:mm")
            .parse(strDateTime));

    long difference = training.getTimeInMillis()
            - now.getTimeInMillis();

    if (difference < 15 * 60 * 1000) { // less than 15 minutes


        returnCode = false;
    }

} catch (java.text.ParseException e) {
    e.printStackTrace();
    //returnCode = false;
}

return returnCode;