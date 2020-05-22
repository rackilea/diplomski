HttpClient client = new DefaultHttpClient();
        String getURL =URL;
        Log.d("URL",getURL);
        HttpGet get = new HttpGet(getURL);
        get.setHeader("X-CT-API-KEY", (my api key));
        HttpResponse responseGet = client.execute(get);
        HttpEntity resEntityGet = responseGet.getEntity();
        if (resEntityGet != null)
        {
            Log.i("GET ", EntityUtils.toString(resEntityGet));
        }