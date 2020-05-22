String appId = //your application id
  String pageId=//page id to subscribe from
  PostMethod method =
        new PostMethod("https://graph.facebook.com/" + pageId + "/tabs?app_id=" + appId +
              "&method=POST&access_token=" + pageToken);
  HttpClient httpClient = new HttpClient();
  try {
     int statusCode = httpClient.executeMethod(method);
     String response = new String(method.getResponseBody());
     if (statusCode == HttpStatus.SC_OK) {

        // "Completed tab addition"
     }else{
        // "Tab adding failed"
     }

  } catch (Exception e) {
     //"Tab adding failed" 
  }