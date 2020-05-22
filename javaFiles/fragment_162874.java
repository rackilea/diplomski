HttpPost request = new HttpPost("https://www.simyo.es/simyo/portal/j_security_check");
List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
nameValuePairs.add(new BasicNameValuePair("j_username", "PUT_USERNAME_HERE"));
nameValuePairs.add(new BasicNameValuePair("j_password", "PUT_PASSWORD_HERE"));
request.setEntity(new UrlEncodedFormEntity(nameValuePairs));
client.execute(request);