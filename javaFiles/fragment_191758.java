@Override
public void onSaveInstanceState(Bundle savedInstanceState) {
    // we will be stopped and perhaps later on destroyed;
    // store displayed image for quick retrieval in private data space
    try {
        FileOutputStream output =
           openFileOutput(this.getString(R.string.myImage), Context.MODE_PRIVATE);
        myBitmap.compress(Bitmap.CompressFormat.PNG, 100, output);
    } catch (Exception e) {
        Log.e(LOG_TAG, "could not save image to private space");
    }

    // superclass to save the view hierarchy state
    super.onSaveInstanceState(savedInstanceState);
}

@Override
public void onRestoreInstanceState(Bundle savedInstanceState) {
    // superclass to restore the view hierarchy
    super.onRestoreInstanceState(savedInstanceState);

    // retrieve image stored earlier
    try {
        FileInputStream input = openFileInput(this.getString(R.string.myImage));
        ((ImageView) findViewById(R.id.det_mainimage)).
          setImageBitmap(BitmapFactory.decodeStream(input));            
    } catch (Exception e) {
        Log.e(LOG_TAG, "could not retrieve image from private space");
    }
}