HttpClient client = HttpClients.createDefault();
HttpPost httpPost = new HttpPost("http://localhost/so/sendrequest/addInformation.php");

try{
   List<NameValuePair> data = new ArrayList<NameValuePair>(2);
   data.add(new BasicNameValuePair("status", "ok"));
   data.add(new BasicNameValuePair("timein", "12:55"));
   httpPost.setEntity(new UrlEncodedFormEntity(data));
   String response = EntityUtils.toString(client.execute(httpPost).getEntity());
   System.out.println(response); //here you have your insertid
}catch(ClientProtocolException e){
   // TODO Auto-generated catch block
}catch(IOException e){
   // TODO Auto-generated catch block
}