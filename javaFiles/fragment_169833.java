private static final SimpleDateFormat FORMATTER_MMM_d_yyyy = new SimpleDateFormat("MMM d, yyyy", Locale.US);
private static final SimpleDateFormat FORMATTER_dd_MMM_yyyy = new SimpleDateFormat("dd-MMM-YYYY", Locale.US);

public static String formatData(String text) {
    String tmp = null;

    try {
        Date d = FORMATTER_MMM_d_yyyy.parse(text);
        tmp = FORMATTER_dd_MMM_yyyy.format(d);
    } catch (ParseException pe) {
        tmp = text;
    }

    return tmp;
}