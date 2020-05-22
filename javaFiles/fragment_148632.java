HttpURLConnection http = (HttpURLConnection) new URL(highscoreGlobal).openConnection();
  http.setRequestMethod("GET");     //You don't need to set this because HttpURLConnection works with GET in default, but anyway
  http.setReadTimeout( 15*1000);    //Timeout, 15 seconds.
  http.connect();

  BufferedReader reader = new BufferedReader(new InputStreamReader( http.getInputStream()));