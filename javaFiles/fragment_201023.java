public void onTagDiscovered(Tag tag) {
    Log.i(TAG, "New Tag Discovered");

    MainActivity.getInstance().startNewActivity();

});