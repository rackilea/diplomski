public static String readHttpResponse(CloseableHttpResponse response) throws IOException {

    try {
        HttpEntity entity = response.getEntity();
        if (null != entity) {
            return EntityUtils.toString(entity);
        }
    } finally {
        response.close();
    }

    return "";
} // end of readHttpResponse(CloseableHttpResponse response)