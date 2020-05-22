public static boolean isSameDay(Calendar cal1, Calendar cal2) {
            if (cal1 == null || cal2 == null) {
                throw new IllegalArgumentException("The dates must not be null");
            }
            return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
                    cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                    cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
        }



public static boolean isToday(Calendar cal) {
        return isSameDay(cal, Calendar.getInstance());
    }