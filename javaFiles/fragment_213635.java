// Gets the StatusBar's height of the particular display.
    public static int getStatusBarHeight(final Context context) {
        final Resources resources = context.getResources();
        final int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return resources.getDimensionPixelSize(resourceId);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return (int) Math.ceil(24 * resources.getDisplayMetrics().density);
            } else {
                return (int) Math.ceil(25 * resources.getDisplayMetrics().density);
            }
        }
}