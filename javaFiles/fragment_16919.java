HttpResponse resResponse = dhcClient.execute(htpGet);
StatusLine statusLine = resResponse.getStatusLine();
int statusCode = statusLine.getStatusCode();
if (statusCode == HttpURLConnection.HTTP_OK) {
    // Here status code is 200 and you can get normal response
} else {
    // Here status code may be equal to 404, 500 or any other error
}