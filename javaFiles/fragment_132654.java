public String doUrlPost(final String connurl,final JSONObject obj) throws IOException{
              CookieManager cookieManager = new CookieManager();
      CookieHandler.setDefault(cookieManager);

      URL url=new URL(connurl);
       HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
         urlConnection.setDoOutput(true);
         urlConnection.setRequestMethod("POST");
         urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
                 //sets the cookie to version 1
         urlConnection.setRequestProperty("Cookie2","$Version=1");

         List<HttpCookie> lst=((CookieManager)CookieHandler.getDefault()).getCookieStore().getCookies();
         for(HttpCookie cookie:lst){

             if(cookie.getName().equals("auth")){
             //double quote your cookie
              urlConnection.setRequestProperty("Cookie","auth=\""+cookie.getValue()+"\"");
             }
         }
         urlConnection.setUseCaches(false);      

         List<NameValuePair> nameValuePairs = getData(obj);

         OutputStream out = urlConnection.getOutputStream();
         BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(out, "UTF-8"));           
         writer.write(getQuery(nameValuePairs));
         writer.close();

        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        BufferedReader rd=new BufferedReader(new InputStreamReader(in));
        String line="";
        String content="";
        while((line=rd.readLine())!=null){
            content+=line;
        }
        rd.close();
        finalcontent=content;
        urlConnection.disconnect(); 
        return finalcontent;
}