public static String readHttpResponse(CloseableHttpResponse response) throws IOException {
    final StringBuilder builder = new StringBuilder();

    try {
        HttpEntity entity = response.getEntity();
        if (null != entity) {
            InputStream inputStream = entity.getContent();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    builder.append(line);
                }
            } finally {
                inputStream.close();
            }
        }
    } finally {
        response.close();
    }

    return builder.toString();
} // end of readHttpResponse(CloseableHttpResponse response)