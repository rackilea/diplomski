compile 'org.apache.httpcomponents:httpmime:4.3.6'
compile 'org.apache.httpcomponents:httpcore:4.3.3'


  private void sendImage(final String fileString, String fileMessageId)

{
    Bitmap bitmap;
    DataOutputStream dos = null;


    String sResponse = null;
    bitmap = BitmapFactory.decodeFile(fileString);

    File sourceFile = new File(fileString);


    String upLoadServerUri = WSConfig.UPLOAD_FILE_URL;
    HttpClient httpClient = new DefaultHttpClient();

    HttpPost httpPost = new HttpPost(upLoadServerUri);


    try {


        MultipartEntity entity = new MultipartEntity();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        entity.addPart("files",
                new FileBody(sourceFile));


        httpPost.setEntity(entity);
        HttpResponse response;
        try {
            response = httpClient.execute(httpPost);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            response.getEntity().getContent(), "UTF-8"));
            sResponse = reader.readLine();




        } catch (IOException e1) {
            e1.printStackTrace();
        }


    } catch (Exception e) {
        e.printStackTrace();
    }
}