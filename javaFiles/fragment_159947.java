URL url;
try {
    url = new URL(url[0]);
    if(url.getProtocol().equalsIgnoreCase(HTTPS){
        Lod.i(TAG, "Is HTTPS connection");
    } else {
        Log.i(TAG, "Is HTTP connection");
    }
} catch (EOFException eofEx) {
    eofEx.printStackTrace();
}