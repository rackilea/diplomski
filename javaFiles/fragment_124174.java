Bundle extras = intent.getExtras();
if (extras != null) {
    if (extras.containsKey("isNewItem")) {
        boolean isNew = extras.getBoolean("isNewItem", false);

        // do something with these values
    }
}