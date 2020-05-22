public static String get(String from) {
        try {
            HttpClient client = new DefaultHttpClient();  
            HttpGet get = new HttpGet(from);
            HttpResponse responseGet = client.execute(get);  
            HttpEntity resEntityGet = responseGet.getEntity();  
            if (resEntityGet != null) return EntityUtils.toString(resEntityGet);
        } catch (Exception e) {
            Log.e("", e.toString());
        }
        return null;
    }