String strAuth = DoAESEncrypt("userid:pwd");
        String strContent = DoAESEncrypt("{\"Name\":Tester,\"Id\":\"123\",\"NickName\":null,\"IsLocked\":false}");

          HttpClient client =  new DefaultHttpClient();          
          HttpPost post = new HttpPost("https://domainname/servicename");
          post.addHeader("auth",strAuth.replace("\n","").replace("\r","");
          post.addHeader("Content-Type", "application/json");
          StringEntity input = new StringEntity(strContent);
          post.setEntity(input);
          HttpResponse response = client.execute(post);