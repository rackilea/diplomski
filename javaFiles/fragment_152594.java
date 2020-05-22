HttpHost targetHost = new HttpHost("localhost", 8080, "http");
           DefaultHttpClient httpclient = new DefaultHttpClient();
           BasicHttpContext ctx = new BasicHttpContext();
           // Plugin Context Use for Liferay 6.1
           HttpPost post = new HttpPost("/api/jsonws/country/get-countries");
           Base64 b = new Base64();
        String encoding = b.encodeAsString(new String("test@liferay.com:test").getBytes());
        post.setHeader("Authorization", "Basic " + encoding);
           List<NameValuePair> params = new ArrayList<NameValuePair>();
           //params.add(new BasicNameValuePair("emplyeeId", "30722"));
           UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, "UTF-8");
           post.setEntity(entity);
           HttpResponse resp = httpclient.execute(targetHost, post, ctx);
           resp.getEntity().writeTo(System.out);
           httpclient.getConnectionManager().shutdown();

     }