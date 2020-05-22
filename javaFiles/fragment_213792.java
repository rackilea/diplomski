public static void upload(URL url, File file) throws IOException, URISyntaxException {
    HttpClient client = new DefaultHttpClient(); //The client object which will do the upload
    HttpPost httpPost = new HttpPost(url.toURI()); //The POST request to send

    FileBody fileB = new FileBody(file);

    MultipartEntity request = new MultipartEntity(); //The HTTP entity which will holds the different body parts, here the file
    request.addPart("file", fileB);

    httpPost.setEntity(request);
    HttpResponse response = client.execute(httpPost); //Once the upload is complete (successful or not), the client will return a response given by the server

    if(response.getStatusLine().getStatusCode()==200) { //If the code contained in this response equals 200, then the upload is successful (and ready to be processed by the php code)
        System.out.println("Upload successful !");
    }
}