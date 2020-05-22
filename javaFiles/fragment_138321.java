@Override
    protected String doInBackground(Void... params) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpContext localContext = new BasicHttpContext();

        // Finds todays date and adds that into the URL
        //Calendar c = Calendar.getInstance();
        //System.out.println("Current time => " + c.getTime());
        SimpleDateFormat df = new SimpleDateFormat("dd/MM");
        String formattedDate = df.format(now.getTime());

        String finalURL = "http://www.earthtools.org/sun/"
                + LatCoord.getText().toString().trim() + "/"
                + LongCoord.getText().toString().trim() + "/"
                + formattedDate + "/99/0";
        HttpGet httpGet = new HttpGet(finalURL);
        String text = null;

        try {
            HttpResponse response = httpClient.execute(httpGet,
                    localContext);
            HttpEntity entity = response.getEntity();
            text = getASCIIContentFromEntity(entity);
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
        return text;
    }