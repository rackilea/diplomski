private static final String[] DATE_PATTERNS = new String[] {...};
private static final ThreadLocal<SimpleDateFormat[]> DATE_FORMATS = 
    new ThreadLocal<SimpleDateFormat[]>() {
        @Override
        protected SimpleDateFormat[] initialValue() {
            List<SimpleDateFormat> formatList = new ArrayList<SimpleDateFormat>();

            for (String pattern : DATE_PATTERNS)
            {
                formatList.add(new SimpleDateFormat(pattern));
            }

            return formatList.toArray(new SimpleDateFormat[formatList.size()]);
        }
    };

public static SimpleDateFormat[] getDateFormats() {
    return DATE_FORMATS.get();
}