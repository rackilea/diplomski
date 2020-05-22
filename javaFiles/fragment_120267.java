String url = "http://xx.xx.xx.xx:5000/models/images/one.json";

URL obj = new URL(url);
HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

conn.setRequestProperty("Content-Type", "application/json");
conn.setDoOutput(true);

conn.setRequestMethod("POST");

//build it this way
Uri.Builder builder = new Uri.Builder()
        .appendQueryParameter("firstParam", paramValue1)
        .appendQueryParameter("secondParam", paramValue2)
        .appendQueryParameter("thirdParam", paramValue3);
String query = builder.build().getEncodedQuery();

OutputStream os = conn.getOutputStream();
BufferedWriter writer = new BufferedWriter(
            new OutputStreamWriter(os, "UTF-8"));
writer.write(query);
writer.flush();