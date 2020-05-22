public void upload(String filepath) throws IOException
    {
     HttpClient httpclient = new DefaultHttpClient();
     httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
     HttpPost httppost = new HttpPost("url");
     File file = new File(filepath);
     MultipartEntity mpEntity = new MultipartEntity();
     ContentBody cbFile = new FileBody(file, "image/jpeg");
     mpEntity.addPart("userfile", cbFile); 
     httppost.setEntity(mpEntity);
     System.out.println("executing request " + httppost.getRequestLine());
     HttpResponse response = httpclient.execute(httppost);
     HttpEntity resEntity = response.getEntity();
             // check the response and do what is required
      }