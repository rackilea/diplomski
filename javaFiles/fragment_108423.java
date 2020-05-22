public HttpsURLConnection GetResponse(String url, String urlParameters) {
    HttpsURLConnection con = null;
    DataOutputStream wr = null;
    try{
        URL obj = new URL(url);
        con = (HttpsURLConnection) obj.openConnection();
        //add request header
        con.setRequestMethod("POST");

        // Send post request
        con.setDoOutput(true);
        wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
    }
    catch(Exception e) { //better to catch more specific than Exception
        System.out.println("--------------------There is an error in response function ");
        e.printStackTrace();
        LOGGER.error("There is an arror in AjaxCAll function of login controller."+e.getMessage());
        LOGGER.debug("There is an arror in AjaxCAll function of login controller.");
        return null;
    }
    finally{
        if(wr != null) {
            wr.close();
        }
    }
    return con;
}