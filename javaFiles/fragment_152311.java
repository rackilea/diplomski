SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ") 
{
    public StringBuffer format(Date date, StringBuffer toAppendTo, java.text.FieldPosition pos) 
    {
        StringBuffer toFix = super.format(date, toAppendTo, pos);
        return toFix.insert(toFix.length()-2, ':');
    };