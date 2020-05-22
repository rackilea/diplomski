List<NameValuePair> bodyParams = new ArrayList<NameValuePair>();
    bodyParams.add(new BasicNameValuePair("param1", params[i]);
    if (bodyParams.size() > 0) {
        try {
            // Include the request body
            post.setEntity(new UrlEncodedFormEntity(bodyParams));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Body parameters produced unsupported encoding?", e);
        }
    }