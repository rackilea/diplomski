public enum DateUtilKeyWords{
 YESTERDAY;
}

public static Date getDate(DateUtilKeyWords dateUtilKeyWord) {
    Calendar cal = Calendar.getInstance();
    switch (dateUtilKeyWord) {
        case YESTERDAY: {
            cal.add(Calendar.DATE, -1);
            break;
        }
    }
    return cal.getTime();
}