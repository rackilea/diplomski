DefaultHttpClient httpClient = new DefaultHttpClient();
HttpGet httpGetRequest = new  HttpGet(fileUrl);
org.apache.http.auth.Credentials credentials = new org.apache.http.auth.NTCredentials(username,password, workstation, domain);
httpClient.getCredentialsProvider().setCredentials(SharePoint_URL, SharePoint_Port),credentials);
HttpResponse response = httpClient.execute(httpGetRequest);
StatusLine status = response.getStatusLine();