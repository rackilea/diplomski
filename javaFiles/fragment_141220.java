URL placeUrl = new URL("https://maps.googleapis.com/maps/api/place/textsearch/json?query=restaurants+in+Sydney&key=AddYourOwnKeyHere");
                HttpURLConnection connection = (HttpURLConnection)placeUrl.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();


                responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {

                    BufferedReader reader = null;

                    InputStream inputStream = connection.getInputStream();
                    StringBuffer buffer = new StringBuffer();
                    if (inputStream == null) {
                        // Nothing to do.
                        return null;
                    }
                    reader = new BufferedReader(new InputStreamReader(inputStream));

                    String line;
                    while ((line = reader.readLine()) != null) {

                        buffer.append(line + "\n");
                    }

                    if (buffer.length() == 0) {
                        return null;
                    }

                    Log.d(TAG, buffer.toString());
                }
                else {
                    Log.i(TAG, "Unsuccessful HTTP Response Code: " + responseCode);
                }