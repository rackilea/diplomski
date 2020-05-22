URL url = new URL("https://currentmillis.com/time/minutes-since-unix-epoch.php");
HttpURLConnection con = (HttpURLConnection) url.openConnection();
con.setRequestMethod("GET");
BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
long minutes = Long.parseLong(in.readLine());
in.close();
con.disconnect();
Instant instant = Instant.ofEpochSecond(minutes * 60);