DateFormatSymbols dfsFr = new DateFormatSymbols(Locale.FRENCH);
    String[] oldMonths = dfsFr.getShortMonths();
    String[] newMonths = new String[oldMonths.length];
    for (int i = 0, len = oldMonths.length; i < len; ++ i) {
        String oldMonth = oldMonths[i];

        if (oldMonth.endsWith(".")) {
            newMonths[i] = oldMonth.substring(0, oldMonths[i].length() - 1);
        } else {
            newMonths[i] = oldMonth;
        }
    }
    dfsFr.setShortMonths(newMonths);
    DateFormat dfFr = new SimpleDateFormat(
        "dd-MMM-yy", dfsFr);

    // English date parser for creating some test data.
    DateFormat dfEn = new SimpleDateFormat(
        "dd-MMM-yy", Locale.ENGLISH);
    System.out.println(dfFr.format(dfEn.parse("10-Oct-09")));
    System.out.println(dfFr.format(dfEn.parse("10-May-09")));
    System.out.println(dfFr.format(dfEn.parse("10-Feb-09")));