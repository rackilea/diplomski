new Thread(new Runnable(){

  public void run(){


    ArrayList<String> urls=new ArrayList<String>(); //to read each line
    //TextView t; //to show the result, please declare and find it inside onCreate()



    try {
         // Create a URL for the desired page
         URL url = new URL("http://somevaliddomain.com/somevalidfile"); //My text file location
         //First open the connection 
         HttpURLConnection conn=(HttpURLConnection) url.openConnection();
         conn.setConnectTimeout(60000); // timing out in a minute

         BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

         //t=(TextView)findViewById(R.id.TextView1); // ideally do this in onCreate()
        String str;
        while ((str = in.readLine()) != null) {
            urls.add(str);
        }
        in.close();
    } catch (Exception e) {
        Log.d("MyTag",e.toString());
    } 

    //since we are in background thread, to post results we have to go back to ui thread. do the following for that

    Activity.this.runOnUiThread(new Runnable(){
      public void run(){
          t.setText(urls.get(0)); // My TextFile has 3 lines
      }
    });

  }
}).start();