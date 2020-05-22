public boolean addAttachmentToIssue(String issueKey, String path){


        String auth = new String(org.apache.commons.codec.binary.Base64.encodeBase64((user+":"+pass).getBytes()));


    HttpClient httpclient = new DefaultHttpClient();
    HttpPost httppost = new HttpPost(baseURL+"issue/"+issueKey+"/attachments");
    httppost.setHeader("X-Atlassian-Token", "nocheck");
    httppost.setHeader("Authorization", "Basic "+auth);
    MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);

    File fileToUpload = new File(path);
    FileBody fileBody = new FileBody(fileToUpload, "application/octet-stream");
    entity.addPart("file", fileBody);

    httppost.setEntity(entity);
    HttpResponse response = null;
    try {
        response = httpclient.execute(httppost);
    } catch (ClientProtocolException e) {
        return false;
    } catch (IOException e) {
        return false;
    }
    HttpEntity result = response.getEntity();

    if(response.getStatusLine().getStatusCode() == 200)
        return true;
    else
        return false;

}