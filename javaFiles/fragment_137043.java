// executes the request and gets the response.
HttpResponse response = client.execute(httpPostRequest);
// get the status code--- 200 = Http.OK
int statusCode = response.getStatusLine().getStatusCode();

HttpEntity httpEntity = response.getEntity();
responseBody = httpEntity.getContent();    

if (statusCode = 200) {
    // process the responseBody. 
}
else{
    // there is some error in responsebody
}