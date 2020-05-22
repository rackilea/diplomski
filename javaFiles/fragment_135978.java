URL urlPage = new URL(url);
HttpURLConnection conn = (HttpURLConnection)urlPage.openConnection();
conn.connect();
BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

//then loop through lines of webpage with br.readLine();