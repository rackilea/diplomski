super.onCreate(savedInstanceState);
setContentView(R.layout.main);
Button OffWifi = (Button)findViewById(R.id.offwifi);
OffWifi.setOnClickListener(new OnClickListener() { 
  public void onClick(View v) {                 
      WifiManager wifiManager = (WifiManager)getBaseContext().getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(false);          
      }        
  });


// remove these lines
// TextView tv = new TextView(this);       
// TextView status = new TextView(this);                  

// add this line
TextView tv= (TextView) findViewById(R.id.tv);


WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE); 
WifiConfiguration wc....

 ect.ect. 

Log.d("WifiPreference", "enableNetwork returned " + b );   

// let's do this later
//tv.setText("You are now connected!  " +
//        "Version 1.1");

//status.setText("The was an error connecting, please try again.");

   //@Override

try {

    Thread.sleep(5000);

     ConnectivityManager connec = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE); 

     if (connec != null && (connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) ||(connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED)){  

            //You are connected, do something online. 

            // setting the ContentView replaces everything, so don't do that
            //setContentView(tv);

            tv.setText("You are now connected!  " +
               "Version 1.1");



        }else if (connec.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED ||  connec.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED ) {              
            //Not connected.         


           //setContentView(status);
           tv.setText("The was an error connecting, please try again.");
        }  

} catch (InterruptedException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}