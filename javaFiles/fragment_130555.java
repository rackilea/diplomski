/**
* Returns the difference between the year represented by this
* <code>Date</code> object and 1900.
*
* @return the year minus 1900 represented by this date object.
* @deprecated Use Calendar instead of Date, and use get(Calendar.YEAR)
* instead.  Note the 1900 difference in the year.
* @see Calendar
* @see #setYear(int)
*/
public int getYear() {
  Calendar cal = Calendar.getInstance();
  cal.setTimeInMillis(time);
  return cal.get(Calendar.YEAR) - 1900;
}