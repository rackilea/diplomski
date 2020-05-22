String contentType = "image/jpeg";
InputStream attachmentIS = null;
try {
    URL url = new URL("http://www.iconhot.com/icon/png/halloween-2009/256/cat-2.png");
    attachmentIS = url.openStream();
} catch (MalformedURLException e1) {
    attachmentIS = null;
    e1.printStackTrace();
} catch (IOException e) {
    attachmentIS = null;
    e.printStackTrace();
}
if (attachmentIS == null)
   return "failure";
InputStreamContent mediaContent = new InputStreamContent(contentType, attachmentIS);
try {
    service.timeline().insert(timelineItem, mediaContent).setOauthToken((String) params[0]).execute();
    return "success"; 
}
catch (Exception e) {               
    Log.d("Failure", e.getMessage());
    return "failure"; 
}