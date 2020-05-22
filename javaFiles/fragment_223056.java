URL url = new URL(strUrl);  

            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Host", "myhost.com");
            conn.setRequestProperty("Authorization", "Basic " + Base64.encodeToString(toencode, Base64.DEFAULT));
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; PPC; en-US; rv:1.3.1)");
            conn.setRequestProperty("Accept-Charset", "UTF-8");

            conn.setConnectTimeout (5000) ; 
            conn.setDoOutput(true); 
            conn.setDoInput(true); 

            BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
            result = Utilities.readStream(in);

            status_code = conn.getResponseCode();

            return result;  
        } catch (MalformedURLException e) {
            return e.getMessage();
          } catch (ProtocolException e) {

                try {
                    status_code = conn.getResponseCode();
                } catch (IOException e1) {
                    status_code = -1;
                }


              return e.getMessage();
          } catch (IOException e) {
                try {
                    status_code = conn.getResponseCode();
                } catch (IOException e1) {
                    status_code = -1;
                }

              return e.getMessage();
          } catch ( Exception e ) {
                try {
                    status_code = conn.getResponseCode();
                } catch (IOException e1) {
                    status_code = -1;
                }
              return e.getMessage();
          } 
            finally
            {
                conn = null;
            }