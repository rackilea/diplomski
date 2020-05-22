void sendEmail(String PHPfileUurl, String receiverEmail, String fromEmail) {
    ParseUser currentUser = ParseUser.getCurrentUser();

    StringBuilder messageBuilder = new StringBuilder();
    for (int i=0; i<productsOrdered.size(); i++){
        messageBuilder.append(productsOrdered.get(i)).append("\n");
    }
    String mess = messageBuilder.toString();


    Map<String,Object> params = new LinkedHashMap<>();
params.put("name", currentUser.getString(Configurations.USER_FULLNAME));
params.put("fromEmail", fromEmail);
params.put("receiverEmail", receiverEmail);
params.put("messageBody", mess);
 params.put("storeName", Configurations.MERCHANT_NAME);
  params.put("shippingAddress", currentUser.getString(Configurations.USER_SHIPPING_ADDRESS);

StringBuilder postData = new StringBuilder();
for (Map.Entry<String,Object> param : params.entrySet()) {
    if (postData.length() != 0) postData.append('&');
    postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
    postData.append('=');
    postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
}
byte[] postDataBytes = postData.toString().getBytes("UTF-8");


    String strURL = PHPfileUurl;

    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    StrictMode.setThreadPolicy(policy);
    try {
        URL url;
        url = new URL(strURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setConnectTimeout(20000);
        conn.setReadTimeout(20000);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);


        if( conn.getResponseCode() == HttpURLConnection.HTTP_OK ){
            InputStream is = conn.getInputStream();
            Log.i(Configurations.TAG, "EMAIL RESPONSE: " + conn.getResponseMessage());
        } else {
            InputStream err = conn.getErrorStream();
            Log.i(Configurations.TAG, "ERROR ON EMAIL: " + err);
        }
    } catch (IOException e) {e.printStackTrace(); }
}