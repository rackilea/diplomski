private String postMethod(String url, HashMap<String, String> headers, String encodedAuthorizationString) throws HttpException, IOException {
    HttpClient client = new HttpClient();
    PostMethod post = new PostMethod(url);
    post.setRequestHeader("Authorization", encodedAuthorizationString);
    if(headers != null && !headers.isEmpty()){
        for(Entry<String, String> entry : headers.entrySet()){
            //post.setRequestHeader(new Header(entry.getKey(), entry.getValue()));
            //in the old code parameters were set as headers (the line above is replaced with the line below)
            post.addParameter(new Header(entry.getKey(), entry.getValue()));
        }
    }
    client.executeMethod(post);
    String responseFromPost = post.getResponseBodyAsString();
    post.releaseConnection();
    return responseFromPost;
}