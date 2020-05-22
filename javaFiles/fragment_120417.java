public static final int DAY_OF_FIVE_YEARS = 843521;  //just any unused number
    public static long firstTime(long in, int period){
        cal.setTimeInMillis(in*1000L);
        if(period == DAY_OF_FIVE_YEARS){
            int year = cal.get(Calendar.YEAR);
            cal.roll(Calendar.YEAR, -(year%5));
            period = Calendar.DAY_OF_YEAR;
        }
        cal.set(period,cal.getActualMinimum(period));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTimeInMillis()/1000L;
    }