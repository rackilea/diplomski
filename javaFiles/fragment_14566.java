ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
nameValuePairs.add(new BasicNameValuePair("startDate", "2014-04-18T05:00:00"));
nameValuePairs.add(new BasicNameValuePair("endDate", "2014-04-18T06:00:00"));

String paramString = URLEncodedUtils.format(nameValuePairs, "utf-8");
HttpPost post = new HttpPost("... basic URL String ..." + paramString);