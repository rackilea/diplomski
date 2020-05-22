public void create(){
          String username = usernameField.getText().toString();
          String password = passwordField.getText().toString();

          // TODO Auto-generated method stub
            HttpClient client = new DefaultHttpClient();
            HttpPost request = new HttpPost("http://localhost/example/insert.php");

            try
            {
                List<NameValuePair>  postparam = new ArrayList<NameValuePair>();
                postparam.add(new BasicNameValuePair("username", username));
                postparam.add(new BasicNameValuePair("password", password));

                httppost.setEntity(new UrlEncodedFormEntity(postparam));
                HttpResponse response = client.execute(request);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }