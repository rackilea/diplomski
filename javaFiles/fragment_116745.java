public static void main(String[] args) throws IOException {
    Test test=new Test();
    Date fromDate = Calendar.getInstance().getTime();
    System.out.println("UTC Time - "+fromDate);
    System.out.println("GMT Time - "+test.cvtToGmt(fromDate));
}
private  Date cvtToGmt( Date date ){
    TimeZone tz = TimeZone.getDefault();
    Date ret = new Date( date.getTime() - tz.getRawOffset() );

    // if we are now in DST, back off by the delta.  Note that we are checking the GMT date, this is the KEY.
    if ( tz.inDaylightTime( ret )){
        Date dstDate = new Date( ret.getTime() - tz.getDSTSavings() );

        // check to make sure we have not crossed back into standard time
        // this happens when we are on the cusp of DST (7pm the day before the change for PDT)
        if ( tz.inDaylightTime( dstDate )){
            ret = dstDate;
        }
     }
     return ret;
}