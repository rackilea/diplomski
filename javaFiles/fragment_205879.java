public class SharedPrefs {

private static final String SHARED_PREFERENCES_NAME = "user_prefs";
private static final String BOOKING_INFO = "booking";
private static final String BOOKMARK_IMAGE_RESOURCE_INFO = "bookmarkImageResource";
private final SharedPreferences prefs;

public SharedPrefs(Context context) {
    prefs = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
}

public boolean saveBookingInfo(String bookingInfo, String bookmarkImageResource) {
    return prefs.edit()
            .putString(BOOKING_INFO, bookingInfo)
            .putString(BOOKMARK_IMAGE_RESOURCE_INFO, bookmarkImageResource)
            .commit();
}

public Pair<String, String> getBookingInfo() {
    return new Pair<String, String>(
            prefs.getString(BOOKING_INFO, ""),
            prefs.getString(BOOKMARK_IMAGE_RESOURCE_INFO, ""));
}

public void clearAll() {
    prefs.edit().clear().apply();
}