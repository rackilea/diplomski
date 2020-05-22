class CustomDateFormatProvider extends DateFormatProvider {
    public DateFormat getDateInstance(int style, Locale locale) {
        if ( style == DateFormat.MEDIUM && Locale.US.equals(locale) ) {
            return new SimpleDateFormat("yyyy, MMM dd");
        }
        //else do default behaviour
    }

    //...
}