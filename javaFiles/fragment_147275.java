try {
    if(status == HttpStatus.SC_OK) {
        json = httpentity != null ?
            EntityUtils.toString(httpentity, "iso-8859-1") : null;
    } else {
        Log.e("Server responded with error status " + status);
    }
} catch (Exception e) {
    Log.e("Buffer Error", "Error converting result " + e.toString());
}