Looper.prepare();
            HttpClient client = new DefaultHttpClient();
            HttpConnectionParams.setConnectionTimeout(client.getParams(),
                    10000);
            HttpResponse response;
            JSONObject obj = new JSONObject();

            String timey = DateFormat.getDateTimeInstance().format(new Date());

            try {
                HttpPost post = new HttpPost(SERVICE_URL);
                obj.put("lon", longitude);
                obj.put("lat", latitude);
                obj.put("dateTime", timey);
                StringEntity se = new StringEntity(obj.toString());
                se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE,
                        "application/json"));
                post.setEntity(se);
                response = client.execute(post);

                if (response != null) {
                    InputStream in = response.getEntity().getContent();
                }

            } catch (Exception e) {
                e.printStackTrace();

            }

            Looper.loop();