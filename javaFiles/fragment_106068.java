// Month as a number.
int month = 1;

// Sets the Calendar instance to the desired month.
// The "-1" takes into account that Calendar counts months
// beginning from 0.
Calendar c = Calendar.getInstance();
c.set(Calendar.MONTH, month - 1);

// This is to avoid the problem of having a day that is greater than the maximum of the
// month you set. c.getInstance() copies the whole current dateTime from system 
// including day, if you execute this on the 30th of any month and set the Month to 1 
// (February) getDisplayName will get you March as it automatically jumps to the next              
// Month
c.set(Calendar.DAY_OF_MONTH, 1);    

// Returns a String of the month name in the current locale.
c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());