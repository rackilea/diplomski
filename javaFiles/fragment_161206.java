HttpClient http = new DefaultHttpClient();
HttpPut putmethod = new HttpPut("http://abc.com/SETTINGS.TXT");
putmethod.setEntity(new StringEntity(data));
HttpResponse response = http.execute(putmethod);

if (response.getStatusLine().getStatusCode()  == 200) 
            {
                is = response.getEntity().getContent();
                int ch;
                sb = new StringBuffer();
                while ((ch = is.read()) != -1) {
                    sb.append((char) ch);
                }
                // Log sb . it prints the response you get.
            }