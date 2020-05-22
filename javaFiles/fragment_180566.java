// I hope this code snippet is present in the onCreate() method of the activity 
// which has the layout containing this CheckBox set
String key = null;
CheckBox chalan_recvd = (CheckBox) findViewById(R.id.chalan_recvd);
if(chalan_recvd.isChecked()) {
    // Use the key 1 for your webservice
    key = "key1";
} else {
    // Use the key 2 for your webservice
    key = "key2";
}

// Now just send the key to your webservice
String checkbox1 = key;