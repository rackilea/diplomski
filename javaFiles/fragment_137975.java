HttpClient client = new DefaultHttpClient();
            HttpConnectionParams.setConnectionTimeout(client.getParams(), 60000);
            HttpResponse response;

    try
    {

            JSONObject j = new JSONObject();
            j.put("UserName", "hiqmaali");
            j.put("Password", "qwerty");
        Messages.onLowmemory();
        HttpPost post = new HttpPost(HOST_URL);

        StringEntity stringEntity = new StringEntity(j.toString(), "UTF-8");
        post.setEntity(stringEntity);

        response = client.execute(post);