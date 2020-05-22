InputStream stream = getResources().openRawResource(R.raw.data);
try {
        byte[] buffer = new byte[stream.available()];
        stream.read(buffer);
        stream.close();
        Log.i("xml", new String(buffer));
} catch (IOException e) {
    // Error handling
}