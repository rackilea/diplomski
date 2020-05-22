urlConnection = (HttpURLConnection) url
                        .openConnection();
                urlConnection.setDoOutput(true);
                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("Content-Type", "application/json");
                urlConnection.setRequestProperty("x-api-key", x_api);
                urlConnection.setRequestProperty("Accept", "application/json");

                String datajson =  "{\"file\": \""+imageString.trim()+"\"}";
                Log.e("data","json:"+datajson);

                OutputStream os = urlConnection.getOutputStream();
                os.write(datajson.getBytes("UTF-8"));
                os.close();