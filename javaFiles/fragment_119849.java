protected JSONObject doInBackground(String... params) {

            JSONObject json =null;            
            try {
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("matrix_id", matrix_id));
                json = jsonParser.makeHttpRequest(
                        url_subject_details, "GET", params);
                }catch(Exception e)
                {
                  e.printStacktrace();
                }   
    return json;
  }