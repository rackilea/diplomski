JSONParser parser = new JSONParser();
JSONObject jsonObject = (JSONObject)parser.parse("{\"headers\":[{\"name\":\"date\",\"value\":\"Tue, 13 Mar 2018 12:44:55 GMT\"},{\"name\":\"content-encoding\",\"value\":\"gzip\"},{\"name\":\"last-modified\",\"value\":\"Tue, 06 Mar 2018 20:15:30 GMT\"},{\"name\":\"server\",\"value\":\"Apache\"},{\"name\":\"vary\",\"value\":\"Accept-Encoding\"},{\"name\":\"content-type\",\"value\":\"text/html\"},{\"name\":\"status\",\"value\":\"200\"}]}");
JSONArray headers = (JSONArray)jsonObject.get("headers");
headers.forEach( header -> {
    JSONObject headerJsonObject = (JSONObject)header;
    if(headerJsonObject.get("name").equals("content-encoding")){
        System.out.println(headerJsonObject.get("value"));
    }
    // continue
});