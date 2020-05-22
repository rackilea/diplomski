String urlString = "http://localhost:8080/birt_install_folder/frameset?__report=report_folder/report_name.rptdesign&__format=pdf";
GetMethod method = new GetMethod(urlString);
HttpClient client = new HttpClient();
InputStream ret = null;
try {
    client.executeMethod(method);
    InputStream is = new ByteArrayInputStream(method.getResponseBody());
    //TODO use InputStream to create a file and start a download
} catch (Excpetion e){
  //log exception
}