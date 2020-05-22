URL url = new URL(queries.getQuery(sessionBean.getSelectedQuery()));
URLConnection connection = url.openConnection();
connection.setRequestProperty("Content-Type", "application/json");
connection.setDoOutput(true);

String json = "{\"x\": \"hello\"}";

OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
out.write(json);
out.close();

BufferedReader rd2 = new BufferedReader(new InputStreamReader(connection.getInputStream()));

while ((line = rd2.readLine()) != null) {
    result += line;
}
rd2.close();