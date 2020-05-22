public RestoreDefaultApperanceDialogPreference(Context context,
        AttributeSet attrs) {
    super(context, attrs);

    setDialogTitle("Restore default colors?"); // <- this should work
}


@Override
protected void onDialogClosed(boolean positiveResult) {
    super.onDialogClosed(positiveResult);

    if (positiveResult) {
        // OK button is pressed
    } else {
        // Cancel button is pressed
    }
}