String url = "https://api.hooktheory.com/v1/users/auth";
URL obj = new URL(url);
HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

con.setRequestMethod("POST");
con.setRequestProperty("Accept", "application/json");
con.setRequestProperty("Content-Type", "application/json");

// Send post request
con.setDoOutput(true);
DataOutputStream wr = new DataOutputStream(con.getOutputStream());
String requestBody = String.format("{  \"username\": \"%s\", \"password\": \"%s\" }", username, password);
wr.writeBytes(requestBody);
wr.flush();
wr.close();