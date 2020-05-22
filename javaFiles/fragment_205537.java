if (getIntent().getExtras() != null) {
    for (String key : getIntent().getExtras().keySet()) {
        String value = getIntent().getExtras().getString(key);
        Log.d(TAG, "Key: " + key + " Value: " + value);
    }
}