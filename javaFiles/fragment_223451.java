// You can be pretty confident that the intent will not be null here.
Intent intent = getIntent();

// Get the extras (if there are any)
Bundle extras = intent.getExtras();
if (extras != null) {
    if (extras.containsKey("isNewItem")) {
        boolean isNew = extras.getBoolean("isNewItem", false);

        // TODO: Do something with the value of isNew.
    }
}