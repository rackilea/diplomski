HttpPost post = new HttpPost("http://192.168.1.66:8080/login.html");
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(
                    3);
            nameValuePairs.add(new BasicNameValuePair("cmd", "Login"
                    .getText().toString()));
            nameValuePairs.add(new BasicNameValuePair("Username", "test"
                    .getText().toString()));

            nameValuePairs.add(new BasicNameValuePair("Password", "Password"
                    .getText().toString()));

            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));