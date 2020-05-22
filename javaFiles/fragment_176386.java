HttpClient client = new DefaultHttpClient();
            HttpGet get = new HttpGet("my_url");        
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            try {               
                String response = client.execute(get,responseHandler);

            } catch (Exception e) {
                Log.e("RESPONSE", "is "+e.getMessage());                
            }