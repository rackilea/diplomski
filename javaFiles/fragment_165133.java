String appId = //your app id
  String token = //app token appId|appSecret
  String callbackUrl = //your public url
  PostMethod method = new PostMethod();
  method.setURI(new URI("https://graph.facebook.com/" + appId +
           "/subscriptions?callback_url=" + callbackUrl +
         "&object=page&fields=feed&verify_token=streamInit&method=POST&access_token="+
           token, false));

  HttpClient httpClient = new HttpClient();
  if (method != null) {
        int statusCode = httpClient.executeMethod(method);
        String response = new String(method.getResponseBody());
        if (statusCode == HttpStatus.SC_OK) {

                 //Completed streaming initiation
        }else{
           //Streaming initialization failed"
        }
     }
  } catch (Exception e) {

  }