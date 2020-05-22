try {
                // Open connection
                HttpURLConnection httpConn = (HttpURLConnection) conn;
                httpConn.setAllowUserInteraction(false);
                httpConn.setInstanceFollowRedirects(true);
                httpConn.setRequestMethod("GET");
                httpConn.connect();
                response = httpConn.getResponseCode();
                // Check that connection is OK
                if (response == HttpURLConnection.HTTP_OK)
                {
                    // Connection is OK so open a reader
                    anInStream = httpConn.getInputStream();
                    InputStreamReader in= new InputStreamReader(anInStream);
                    BufferedReader bin= new BufferedReader(in);

                    // Read in the data from the RSS stream
                    String line = new String();
                    while (( (line = bin.readLine())) != null)
                    {
                        result = result + "\n" + line;
                        Log.v(TAG, "index=" + result);

                    }
                }
            }