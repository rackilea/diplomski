public static final String PACKAGE_NAME_GOOGLE_NOW = "com.google.android.googlequicksearchbox";
public static final String ACTIVITY_GOOGLE_NOW_SEARCH = ".SearchActivity";

/**
 * Launch Google Now with a specific search term to resolve
 *
 * @param ctx        the application context
 * @param searchTerm the search term to resolve
 * @return true if the search term was handled correctly, false otherwise
 */
public static boolean googleNow(@NonNull final Context ctx, @NonNull final String searchTerm) {
    if (DEBUG) {
        Log.i(CLS_NAME, "googleNow");
    }

    final Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
    intent.setComponent(new ComponentName(PACKAGE_NAME_GOOGLE_NOW,
            PACKAGE_NAME_GOOGLE_NOW + ACTIVITY_GOOGLE_NOW_SEARCH));

    intent.putExtra(SearchManager.QUERY, searchTerm);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP
            | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);

    try {
        ctx.startActivity(intent);
        return true;
    } catch (final ActivityNotFoundException e) {
        if (DEBUG) {
            Log.e(CLS_NAME, "googleNow: ActivityNotFoundException");
            e.printStackTrace();
        }
    } catch (final Exception e) {
        if (DEBUG) {
            Log.e(CLS_NAME, "googleNow: Exception");
            e.printStackTrace();
        }
    }

    return false;

}