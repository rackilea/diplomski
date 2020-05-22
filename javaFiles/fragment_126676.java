Intent intent = new Intent(this, MultipleWifi.class);
        intent.putExtra("SSIDList", SSIDString);
there is key that you are passing 
        startActivityForResult(intent, 1);
//change key you are using wrong key here
 final String[] StringSSID = intent.getStringArrayExtra("SSIDList");