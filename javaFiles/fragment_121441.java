TextView t = (TextView) findViewById(R.id.title_image);
try {

                url = new URL("https://chex-triplebyte.herokuapp.com/api/cats?page=0");

                urlConnection = (HttpURLConnection) url
                        .openConnection();
                urlConnection.connect();

                InputStream in = urlConnection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(in));
                //InputStreamReader isw = new InputStreamReader(in);
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                String JsonResponse= buffer.toString();

                JSONObject jsonobj = new JSONObject(JsonResponse);
                JSONArray jarray = jsono.getJSONArray("jsontitle");

            for (int i = 0; i < jarray.length(); i++) {
                JSONObject object = jarray.getJSONObject(i);


                 t.setText(object.getString("title"));


            }
           } catch (JSONException e) {
              e.printStackTrace();
            }