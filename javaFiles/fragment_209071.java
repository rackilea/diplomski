TypedValue value = new TypedValue();
    getResources().getValue(resourceId, value, true);
    // check value.string if not null - it is not null for drawables...

    Log.d(TAG, "Resource filename:" + value.string.toString());
    // ^^ This would print res/drawable/pic.jpg