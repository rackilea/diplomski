for (int i = 0; i<notesArray.size(); i++ ){
    try {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        Date past = format.parse(notesTimeStampArray.get(i));
        Date now = new Date();
        String TimeStamp;

        if ( TimeUnit.MILLISECONDS.toSeconds(now.getTime() - past.getTime())  < 60  ) {
            //second
            TimeStamp =  (TimeUnit.MILLISECONDS.toSeconds(now.getTime() - past.getTime()) + "s");
            arrayList.add(TimeStamp);
        } else if (TimeUnit.MILLISECONDS.toSeconds(now.getTime() - past.getTime())  < 3600) {
            //minute
            TimeStamp =  (TimeUnit.MILLISECONDS.toMinutes(now.getTime() - past.getTime()) + "m");
            arrayList.add(TimeStamp);
        } else if (TimeUnit.MILLISECONDS.toSeconds(now.getTime() - past.getTime())  < 86400){
            //hour
            TimeStamp =  (TimeUnit.MILLISECONDS.toHours(now.getTime() - past.getTime()) + "h");
            arrayList.add(TimeStamp);
        } else if (TimeUnit.MILLISECONDS.toSeconds(now.getTime() - past.getTime())  < 604800){
            //day
            TimeStamp =  (TimeUnit.MILLISECONDS.toDays(now.getTime() - past.getTime()) + "d");
            arrayList.add(TimeStamp);
        } else {
            //week
            TimeStamp =  (TimeUnit.MILLISECONDS.toDays(now.getTime() - past.getTime())/7 + "w") ;
            arrayList.add(TimeStamp);
        }
    } catch (Exception j){
        j.printStackTrace();
    }
    data.add(current);
}