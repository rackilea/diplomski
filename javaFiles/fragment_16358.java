public class TryFile {
    public static void main(String[] ar)
           throws HttpException, IOException, URISyntaxException {
        TryFile t = new TryFile();
        t.method();
    }
    public void method() throws HttpException, IOException, URISyntaxException {
        String url = "http://encodable.com/uploaddemo/";
        String fileName = ""; //file name to be uploaded
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);
        FileBody fileContent = new FiSystem.out.println("hello");
        StringBody comment = new StringBody("Filename: " + fileName);
        MultipartEntity reqEntity = new MultipartEntity();
        reqEntity.addPart("file", fileContent);
        httppost.setEntity(reqEntity);

        HttpResponse response = httpclient.execute(httppost);
        HttpEntity resEntity = response.getEntity();
    }
}