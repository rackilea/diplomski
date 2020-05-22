DefaultHttpClient httpclient = new DefaultHttpClient();
HttpResponse response = (HttpResponse) httpclient.execute(httpPostRequest);//send a request and receive a response
        System.out.println("HTTPResponse received in [" + (System.currentTimeMillis()-t) + "ms]");

        HttpEntity entity = response.getEntity();

        if (entity != null) {
            // Read the content stream
            InputStream instream = entity.getContent();





            // convert content stream to a String
            String resultString= convertStreamToString(instream);
            instream.close();
            resultString = resultString.substring(1,resultString.length()-1); // remove wrapping "[" and "]"