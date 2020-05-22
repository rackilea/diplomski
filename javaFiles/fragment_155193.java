public InputStreamReader getJsonStreamReader(String file){
    InputStreamReader reader = null;
    try {
        InputStream in = getAssets().open(file);
        reader = new InputStreamReader(in);
    }catch(IOException ioe){
        Log.e("launch", "error : " + ioe);
        }
    return reader;
}