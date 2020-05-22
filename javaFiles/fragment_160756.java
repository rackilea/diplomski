try {
    stream = downloadUrl(urlString);
    content= contentgetter.parse(stream,urlBlogtitle);
    Log.d(TAG,content.get(0).summary != null ? content.get(0).summary : "NULL");

    // Makes sure that the InputStream is closed after the app is
    // finished using it.
} catch (NullPointerException e) {
    Log.d("ERROR","Response is null!");
} finally {
    if (stream != null) {
        stream.close();
    }
}