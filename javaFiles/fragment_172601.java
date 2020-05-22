private void postData(String value_id,String value_seaction,String value_item,String value_descration) {

        HttpParams httpParameters = new BasicHttpParams();
        HttpProtocolParams.setContentCharset(httpParameters, HTTP.UTF_8);
        HttpProtocolParams.setHttpElementCharset(httpParameters, HTTP.UTF_8);

           HttpClient httpclient = new DefaultHttpClient(httpParameters);
          // HttpPost httppost = new HttpPost("http://rafsanjan.uni-azad.ebrahiminezhad.ir/json/darkhasr.php?shdaneshjo="+value_id+"&moavenat="+value_seaction+"&darkhast="+zir_item+"&startdate=test&tozih="+ value_descration);  //???
           try {
               URIBuilder builder = new URIBuilder();
               builder.setScheme("http")
                       .setHost("app.iaurafsanjan.ac.ir")
                       .setPort(1180)
                       .setPath("/json2/darkhasr.php")
                       .addParameter("shdaneshjo", value_id)
                       .addParameter("moavenat", value_seaction)
                       .addParameter("darkhast", value_item)
                       .addParameter("startdatet", "0")
                       .addParameter("tozih", value_descration)
                       .build();
               // .fragment("section-name");
               String myUrl = builder.toString();
               Log.d("url=>",myUrl);

               HttpPost httppost = new HttpPost(myUrl);

               ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(8);
               //nameValuePairs.add(new BasicNameValuePair("name", name));
               httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
               HttpResponse response = httpclient.execute(httppost);
               HttpEntity resEntity = response.getEntity();  
               Log.d("RESPONSE",EntityUtils.toString(resEntity));

           }
           catch(Exception e)
           {
               Log.e("log_tag", "Error:  "+e.toString());
           }


       }