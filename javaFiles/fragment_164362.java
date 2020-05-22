InputStream inputStream;
int responseStatusCode = urlConnection.getResponseCode();
if( status != HttpURLConnection.HTTP_OK ) { 
    inputStream = urlConnection.getErrorStream();
    //Get more informations about the problem
} else {
    inputStream = urlConnection.getInputStream();
}