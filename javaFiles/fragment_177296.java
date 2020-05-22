final Button mbutton = (Button) findViewById(R.id.httpcheck);
mbutton.setOnClickListener(new View.OnClickListener(){
    public void onClick(View v){

      //call asynctask containing isConntectedToServer method here

    }
});

//put this code in an asynctask and call it there
 public boolean isConnectedToServer(String url, int timeout) {
            try{
                URL myUrl = new URL("http://www.google.co.uk");
                URLConnection connection = myUrl.openConnection();
                connection.setConnectTimeout(timeout);
                connection.connect();
                return true;
            } catch (Exception e) {
                return false;
            }
        }