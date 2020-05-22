List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
nameValuePairs.add(new BasicNameValuePair("__EVENTTARGET", eventTarget));
nameValuePairs.add(new BasicNameValuePair("__EVENTARGUMENT", "1"));
nameValuePairs.add(new BasicNameValuePair("__VIEWSTATE", doc.select("input#__VIEWSTATE").attr("value")));
nameValuePairs.add(new BasicNameValuePair("__LASTFOCUS", ""));
post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
// Execute HTTP Post Request
response = client.execute(post);