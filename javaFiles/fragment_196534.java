if(aImagePath.size() != 0) {
    Collections.reverse(aImagePath);  // reverse the Array

    // Call an AsyncTask to create and retrieve each Bitmap
    // then, in onPostExecute(), populate the Adapter of the GridView
} else {
    // No pictures taken 10 min ago!
}