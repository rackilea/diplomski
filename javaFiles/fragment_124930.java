public static int getResponseCode(String link) {
    URL url;
    HttpURLConnection con = null;
    Integer responsecode = 0;
    try {
        url = new URL(link);
        con = (HttpURLConnection) url.openConnection();
        con.setConnectTimeout(1000); //set time out 
        responsecode = con.getResponseCode();
    } catch (Exception e) {
        // skip
    } finally {
        if (null != con)
            con.disconnect();
    }
    return responsecode;
}