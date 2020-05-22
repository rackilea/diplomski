Map<Integer, String> timeInterval(int perDay)
{
    int minutes = 1440/perDay ;
    Map<Integer, String> timeInt = new HashMap<Integer, String>() ;
    LocalTime time =  DateTimeFormat.forPattern("HH:mm").parseLocalTime("09:00");

    for(int i=0; i < perDay; i++) {
        timeInt.put(i,time.toString());
        time = time.plusMinutes(minutes);
    }

    return timeInt;
}