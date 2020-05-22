String response;

HttpURLConnection connection = (HttpURLConnection)url.openConnection();
connection.setReadTimeout(10000);
connection.setConnectTimeout(10000);
connection.setRequestMethod("GET");
connection.setUseCaches(false);
connection.setAllowUserInteraction(false);
connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
int responceCode = connection.getResponseCode();

if (responceCode == HttpURLConnection.HTTP_OK)
{
     String line;
     BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
     while ((line = br.readLine()) != null)
     {
          response = "";// String variable declared global
          response += line;
          Log.i("response_line", response);
     }
 }
 else 
 {
      response = "";
 }