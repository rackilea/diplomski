public String loadJSONFromAsset() {
    String json = null;
    InputStream is = null;
    try {
        is = getAssets().open("cat.json");
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        json = new String(buffer, "UTF-8");
    }
    catch (IOException ex) {
        ex.printStackTrace();
    }
    finally {
        if (is != null) {
            try {
                is.close();
            }
            catch (IOException ex) {
                // Do you want to handle this exception?
            }
        }
    }
    return json;
}