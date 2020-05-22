@Override
public String getBodyContentType() {
    //for settings the content=type header, the right way...
    return return "text/html";
}

@Override
public byte[] getBody() throws AuthFailureError {
    Map<String, String> params = getParams();
        if (params != null && params.size() > 0) {
            return encodeParameters(params, getParamsEncoding());
        }
    return null; 
}

//Hax.......
private byte[] encodeParameters(Map<String, String> params, String paramsEncoding){
    StringBuilder encodedParams = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                encodedParams.append(entry.getKey());
                //encodedParams.append(':');
                encodedParams.append(entry.
                //encodedParams.append('&');
            }
            return encodedParams.toString().getBytes(paramsEncoding);
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException("Encoding not supported: " + paramsEncoding, uee);
        }
}