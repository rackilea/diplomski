public final class CaseInsensitiveNumberFormat extends NumberFormat {
    private final NumberFormat mParent;
    private final Locale mLocale;

    public CaseInsensitiveNumberFormat(Locale locale) {
        mParent = NumberFormat.getInstance(locale);
        mLocale = locale;
    }

    @Override
    public final Number parse(String s, ParsePosition pos) {
        return mParent.parse(s.toUpperCase(mLocale), pos);   // <------
    }

    @Override
    public final StringBuffer format(double number, StringBuffer appendTo, FieldPosition pos) {
        return mParent.format(number, appendTo, pos);
    }

    @Override
    public final StringBuffer format(long number, StringBuffer appendTo, FieldPosition pos) {
        return mParent.format(number, appendTo, pos);
    }
}