private Calendar fromTime;
private Calendar toTime;
private Calendar currentTime;

public boolean checkTime(String time) {
try {
    String[] times = time.split("-");
    String[] from = times[0].split(":");
    String[] until = times[1].split(":");

    fromTime = Calendar.getInstance();
    fromTime.set(Calendar.HOUR_OF_DAY, Integer.valueOf(from[0]));
    fromTime.set(Calendar.MINUTE, Integer.valueOf(from[1]));

    toTime = Calendar.getInstance();
    toTime.set(Calendar.HOUR_OF_DAY, Integer.valueOf(until[0]));
    toTime.set(Calendar.MINUTE, Integer.valueOf(until[1]));

    currentTime = Calendar.getInstance();
    currentTime.set(Calendar.HOUR_OF_DAY, Calendar.HOUR_OF_DAY);
    currentTime.set(Calendar.MINUTE, Calendar.MINUTE);
    if(currentTime.after(fromTime) && currentTime.before(toTime)){
        return true;
    }
    } catch (Exception e) {
        return false;
    }
    return false;
}