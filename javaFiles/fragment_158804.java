HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(HTTP_REQUEST_URL);

            //create and assign post request server data
            String latitude = loc.getLatitude() + "";
            String longitude = loc.getLongitude() + "";
            String time = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime()) + "";
            String whr = WhereAmI(loc.getLatitude(), loc.getLongitude());

            //data back from server
            String responseBackFromServer = "";

            try {
                List<NameValuePair> pairs = new ArrayList<NameValuePair>();

                pairs.add(new BasicNameValuePair("latitude", latitude));
                pairs.add(new BasicNameValuePair("longitude", longitude));
                pairs.add(new BasicNameValuePair("whereAmI", whr));
                pairs.add(new BasicNameValuePair("time", time));

                post.setEntity(new UrlEncodedFormEntity(pairs));
                HttpResponse server_response = client.execute(post);

                responseBackFromServer = EntityUtils.toString(server_response.getEntity());

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "Response Back: " + responseBackFromServer;