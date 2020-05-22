URL u = new URL(url);
HttpURLConnection conn = (HttpURLConnection)
        u.openConnection();
conn.connect();

reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));