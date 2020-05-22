Response response = restClient.performRequest("HEAD", "/" + indexname); 
int statusCode = response.getStatusLine().getStatusCode(); 
if (statusCode == 404) {
   // index does not exist
} else {
   // index exists
}