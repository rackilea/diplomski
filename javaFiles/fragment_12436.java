public class ServerThread implements Runnable {
    public void run(){
        try{
            if ( SERVERIP != null){
                serverStatus.setText("Listening on IP: " + ip_address_conversion + ":" + SERVERPORT);
                serverSocket = new ServerSocket(SERVERPORT);
                while (true){
                    Socket client = serverSocket.accept();
                    handler.post(new Runnable(){
                        @Override
                        public void run(){
                            serverStatus.setText("Connected");  
                        }
                    });
                    InetAddress ip_client = client.getInetAddress();
                    Log.i("Log", "ip client "+ip_client);
                    //Here i have to find the url params
                    //Find some way to convert your ip_client into string with all parameters together.. or do not use getInetAddress, but rather something easier.
                    LinkedHashMap<String, List<String>> parameters = getQueryParams("192.168.1.110:80/?id=123");  //use String address you get from client object
                }
            }
        } catch (Exception e){
            serverStatus.setText("Error");
        }
    }

    public static LinkedHashMap<String, List<String>> getQueryParams(String url) {
        //You can change to Map or HashMap if order of parameters does not matter for you
        try {
            LinkedHashMap<String, List<String>> params = new LinkedHashMap<String, List<String>>();
            String[] urlParts = url.split("\\?");
            if (urlParts.length > 1) {
                String query = urlParts[1];
                for (String param : query.split("&")) {
                    String[] pair = param.split("=");
                    String key = URLDecoder.decode(pair[0], "UTF-8");
                    String value = "";
                    if (pair.length > 1) {
                        value = URLDecoder.decode(pair[1], "UTF-8");
                    }

                    List<String> values = params.get(key);
                    if (values == null) {
                        values = new ArrayList<String>();
                        params.put(key, values);
                    }
                    values.add(value);
                }
            }

            return params;
        } catch (UnsupportedEncodingException ex) {
            throw new AssertionError(ex);
        }
    }
}