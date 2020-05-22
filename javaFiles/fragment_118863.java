DateFormat df = new DateFormat() {
    static final String FORMAT1 = "yyyyMMddHHmmss";
    static final String FORMAT2 = "yyyyMMddHHmmssz";
    final SimpleDateFormat sdf1 = new SimpleDateFormat(FORMAT1);
    final SimpleDateFormat sdf2 = new SimpleDateFormat(FORMAT2);
    @Override
    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Date parse(String source, ParsePosition pos) {
        if (source.length() - pos.getIndex() == FORMAT1.length())
            return sdf1.parse(source, pos);
        return sdf2.parse(source, pos);
    }
};
System.out.println(df.parse("20110102030405"));
System.out.println(df.parse("20110102030405PST"));