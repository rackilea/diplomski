private String sendHttpPost(String url, String msg)
        throws Exception {

    HttpPost post = new HttpPost(url);

    StringEntity stringEntity = new StringEntity(msg, "UTF-8");
    post.setEntity(stringEntity);


    return execute(post);
}