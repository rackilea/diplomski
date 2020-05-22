System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
URL url = new URL("http://172.217.26.100/about/"); // one of the google IP
HttpURLConnection conn = (HttpURLConnection)url.openConnection();
conn.setRequestProperty("host","www.google.co.jp"); // get japanese google site, you may obtain canada site by changing to `www.google.ca`
BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
System.out.println(reader.readLine());