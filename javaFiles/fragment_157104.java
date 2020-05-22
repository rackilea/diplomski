public static HttpPut createHttpPutWithBody(String body) {
    HttpPut put = new HttpPut(url);
    try {
        put.setEntity(new StringEntity(body, "UTF-8"));
        return put;
    } catch (UnsupportedEncodingException e) {
        throw new InconceivableException("You keep using that encoding. "
            + "I do not think it means what you think it means.", e);
    }
}