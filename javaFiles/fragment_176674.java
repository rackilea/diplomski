String xml = "your xml";
PostMethod post = new PostMethod(strURL);     
try {
    StringRequestEntity requestEntity = new StringRequestEntity(xml);
    post.setRequestEntity(requestEntity); ..
    ....
    ...