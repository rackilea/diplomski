try{
    // First Call
    response = httpClient.execute(httpPost);    
} catch(SocketTimeoutException e){
    httpPost.setParams(...); // change param
    //Second Call
    response = httpClient.execute(httpPost);
}