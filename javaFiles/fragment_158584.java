/**
 * Sets the date field parameters to the values given by {@code year},
 * {@code month}, and {@code dayOfMonth}. This method is equivalent to
 * a call to:
 * <pre>
 *   setFields(Calendar.YEAR, year,
 *             Calendar.MONTH, month,
 *             Calendar.DAY_OF_MONTH, dayOfMonth);</pre>
 *
 * @param year       the {@link Calendar#YEAR YEAR} value
 * @param month      the {@link Calendar#MONTH MONTH} value
 *                   (the month numbering is <em>0-based</em>).
 * @param dayOfMonth the {@link Calendar#DAY_OF_MONTH DAY_OF_MONTH} value
 * @return this {@code Calendar.Builder}
 */
public Builder setDate(int year, int month, int dayOfMonth) {
    return setFields(YEAR, year, MONTH, month, DAY_OF_MONTH, dayOfMonth);
}