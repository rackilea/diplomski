HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
conn.setRequestMethod("PUT");
conn.setDoOutput(true);
conn.setRequestProperty("Accept", "application/vnd.twitchtv.v2+json");
conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

String data = "channel[status]=testing";
data = URLEncoder.encode(data, "UTF-8");