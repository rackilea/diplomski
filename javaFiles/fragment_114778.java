private static final class GMTDateTransform implements Transform<Date>
{
    ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<SimpleDateFormat> () {
        protected SimpleDateFormat initialValue ()
        {
            SimpleDateFormat r = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss.SSS zzz");
            r.setTimeZone (TimeZone.getTimeZone ("GMT"));
            return r;
        }
    };

    public Date read (String source) throws Exception 
    {
        return sdf.get ().parse (source);
    }
    public String write (Date source) throws Exception
    {
        return sdf.get ().format (source);
    }
}