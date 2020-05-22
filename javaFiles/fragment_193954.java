double lat1 = 40.74560;
   double lon1 = -73.94622000000001;
   double lat2 = 46.59122000000001;
   double lon2 = -112.004230;

   String url = "http://maps.googleapis.com/maps/api/directions/json?";

   List<NameValuePair> params = new LinkedList<NameValuePair>();
   params.add(new BasicNameValuePair("origin", lat1 + "," + lon1));
   params.add(new BasicNameValuePair("destination", lat2 + "," + lon2));
   params.add(new BasicNameValuePair("sensor", "false"));

   String paramString = URLEncodedUtils.format(params, "utf-8");
   url += paramString;
   HttpGet get = new HttpGet(url);