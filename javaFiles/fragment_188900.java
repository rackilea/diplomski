// Build today date and current month strings which will be used as keys
String todayDate = getDateFromFormat("dd-MM-yyyy");
String currentMonth = getDateFromFormat("MM-yyyy");

// Try to get the remaining limit from sharedpreferences, and give them default
// values if they don't exist yet
int remainingForToday = sharedPreferences.getInt(todayDate, 5);
int remainingThisMonth = sharedPreferences.getInt(currentMonth, 30);

// When the user clicks on the button, decrement and save the remaining 
sharedPreferences.edit().putInt(todayDate, remainingForToday - 1).apply();
sharedPreferences.edit().putInt(currentMonth, remainingThisMonth - 1).apply();

// Utility function to get the date time strings using native Java classes
private String getDateFromFormat(String format) {
    Calendar today = Calendar.getInstance();
    SimpleDateFormat formatter = new SimpleDateFormat(format);
    return formatter.format(today.getTime());
}