URI uri = new URI("the server address goes here");
HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
conn.setDoOutput(true);
conn.setRequestMethod("PUT");
conn.addRequestProperty("Content-Type", "application/json");
OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
out.write(gson.toJson(newClient));
out.close();
// Check here that you succeeded!