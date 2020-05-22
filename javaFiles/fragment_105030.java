try 
        {
                    String sURL = "https://api.twitch.tv/kraken/search/streams?q=starcraft";

                    URL url = new URL(sURL);
                    HttpURLConnection request = (HttpURLConnection)url.openConnection();
                    request.connect();

                    JsonParser jp = new JsonParser();
                    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
                    JsonArray streams = root.getAsJsonObject().get("streams").getAsJsonArray();
                    for (JsonElement stream : streams)
                    {
                        System.out.println(stream.getAsJsonObject().get("_id"));
                        JsonElement channel = stream.getAsJsonObject().get("channel");
                        System.out.println(channel.getAsJsonObject().get("display_name"));
                        System.out.println(channel.getAsJsonObject().get("url"));
                    }
        } catch (Exception ex) {
            ex.printStackTrace();
        }