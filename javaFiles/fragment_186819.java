Thread thread = new Thread() {
        @Override
        public void run() {
            try {
            //  while(socket.isConnected()){

                writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

                JSONObject myJson = new JSONObject();
                JSONArray list = new JSONArray();
                ... //do something useful for JsonTransformation

writer.write(myJson.toString());

 }
}catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeSocket();
            }
 }