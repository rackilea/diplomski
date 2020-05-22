final URL url = new URL("http://api.relateddigital.com/resta/api/Datawarehouse/InsertUpdateRowInDwTable");
        final HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
...
...
...
if ((connection.getResponseCode() < 200) || (connection.getResponseCode() >= 300))
        {
            final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            final StringBuilder builder = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null)
            {
                builder.append(inputLine);
            }

            System.out.println("Error builder::" + builder);
            in.close();
            return;
        }