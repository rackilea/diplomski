int responseCode = -1;
                feedURL = "your URL"
                HttpURLConnection connection;
                connection = (HttpURLConnection) feedURL.openConnection();
                connection.connect();
                responseCode = connection.getResponseCode();