/* Define one-century window into which to disambiguate dates using
 * two-digit years.
 */
private void parseAmbiguousDatesAsAfter(Date startDate) {
    defaultCenturyStart = startDate;
    calendar.setTime(startDate);
    defaultCenturyStartYear = calendar.get(Calendar.YEAR);
}

/**
 * Sets the 100-year period 2-digit years will be interpreted as being in
 * to begin on the date the user specifies.
 *
 * @param startDate During parsing, two digit years will be placed in the range
 * <code>startDate</code> to <code>startDate + 100 years</code>.
 * @see #get2DigitYearStart
 * @since 1.2
 */
public void set2DigitYearStart(Date startDate) {
    parseAmbiguousDatesAsAfter(startDate);
}