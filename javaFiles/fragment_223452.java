Bundle extras = getIntent().getExtras();
if (extras != null) {
    boolean isNew = extras.getBoolean("isNewItem", false);
    if (isNew) {
        // Do something
    } else {
        // Do something else
    }
}