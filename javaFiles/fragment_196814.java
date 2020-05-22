@StringRes
public int getResourceId(@StringRes int baseResourceId) {
    // Assume baseResourceId == R.string.car_name
    if (state == 1) {
        final Resources res = getResources();
        // Will return "car_name"
        final String resourceName = res.getResourceEntryName(baseResourceId);

        // Look up and return the integer ID for "car_name_tr"
        return res.getIdentifier(resourceName + "_tr", "string", BuildConfig.APPLICATION_ID);
    } else {
        // Otherwise just return the input
        return baseResourceId;
    }
}