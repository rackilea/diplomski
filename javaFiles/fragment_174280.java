/**
 * List of 1 or more different date formats used for de-serialization attempts. The first of them is
 * used for serialization as well.
 */
private final List<DateFormat> dateFormats = new ArrayList<DateFormat>();

DefaultDateTypeAdapter(Class<? extends Date> dateType) {
    this.dateType = verifyDateType(dateType);
    dateFormats.add(DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.US));
    if (!Locale.getDefault().equals(Locale.US)) {
        dateFormats.add(DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT));
    }
    if (JavaVersion.isJava9OrLater()) {
        dateFormats.add(PreJava9DateFormatProvider.getUSDateTimeFormat(DateFormat.DEFAULT, DateFormat.DEFAULT));
    }
}

DefaultDateTypeAdapter(Class<? extends Date> dateType, String datePattern) {
    this.dateType = verifyDateType(dateType);
    dateFormats.add(new SimpleDateFormat(datePattern, Locale.US));
    if (!Locale.getDefault().equals(Locale.US)) {
        dateFormats.add(new SimpleDateFormat(datePattern));
    }
}

DefaultDateTypeAdapter(Class<? extends Date> dateType, int style) {
    this.dateType = verifyDateType(dateType);
    dateFormats.add(DateFormat.getDateInstance(style, Locale.US));
    if (!Locale.getDefault().equals(Locale.US)) {
        dateFormats.add(DateFormat.getDateInstance(style));
    }
    if (JavaVersion.isJava9OrLater()) {
        dateFormats.add(PreJava9DateFormatProvider.getUSDateFormat(style));
    }
}

public DefaultDateTypeAdapter(int dateStyle, int timeStyle) {
    this(Date.class, dateStyle, timeStyle);
}

public DefaultDateTypeAdapter(Class<? extends Date> dateType, int dateStyle, int timeStyle) {
    this.dateType = verifyDateType(dateType);
    dateFormats.add(DateFormat.getDateTimeInstance(dateStyle, timeStyle, Locale.US));
    if (!Locale.getDefault().equals(Locale.US)) {
        dateFormats.add(DateFormat.getDateTimeInstance(dateStyle, timeStyle));
    }
    if (JavaVersion.isJava9OrLater()) {
        dateFormats.add(PreJava9DateFormatProvider.getUSDateTimeFormat(dateStyle, timeStyle));
    }
}