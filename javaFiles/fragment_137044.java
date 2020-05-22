// Url Encoding the POST parameters
try {
    httpPostRequest.setEntity(new UrlEncodedFormEntity(nameValuePair));
}
catch (UnsupportedEncodingException e) {
    // writing error to Log
    e.printStackTrace();
}