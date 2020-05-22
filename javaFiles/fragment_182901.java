getJodaDateTime();//Your dateTime

java.util.Date utilDate = getJodaDateTime().toDate();//Convert it to java.util.Date

BasicDBObject newDoc = new BasicDBObject("$set",
        new BasicDBObject("office_move_date", utilDate)
);