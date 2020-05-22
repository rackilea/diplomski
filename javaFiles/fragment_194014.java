//Post Data
    List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(2);
    nameValuePair.add(new BasicNameValuePair("cid", "testid"));
    nameValuePair.add(new BasicNameValuePair("test", "testvalue"));

    //Encoding POST data
    try {
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
    } catch (UnsupportedEncodingException e) {
        // log exception
        e.printStackTrace();
    }

    // finally make POST request.