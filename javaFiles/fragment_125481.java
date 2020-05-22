// Turn on location updates and pass to fragment
 mButtonRecord.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
        Log.d(TAG_CONTEXT, "Start Recording clicked.");
        mRequestLocationUpdates = true; // boolean value

        mRequestingLocationUpdates.onRequestLocationUpdates( mRequestLocationUpdates );
    }
});