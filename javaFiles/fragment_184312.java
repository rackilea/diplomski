Thread thread = new Thread(){
public void run(){
  try{                
        URL url = new URL("http://test");                
        HttpURLConnection client = (HttpURLConnection)url.openConnection();
         client.connect();
        int responseCode = client.getResponseCode();

    } catch (IOException e) {
        e.printStackTrace();

    }

 }
};

thread.start();