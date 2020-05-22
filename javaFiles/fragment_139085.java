// creating the Pubnub connection object with minimal args
Pubnub pubnub = new Pubnub("<your_pub_key>", "<your_sub_key>");

// get the SharedPreferences object using private mode 
// so that this uuid is only used/updated by this app SharedPreferences
sharedPrefs = getActivity().getPreferences(Context.MODE_PRIVATE);

// get the current pn_uuid value (first time, it will be null)
String uuid = getResources().getString(R.string.pn_uuid);

// if uuid hasn’t been created/ persisted, then create
// and persist to use for subsequent app loads/connections 
if (uuid == null || uuid.length == 0) {
    // PubNub provides a uuid generator method but you could 
    // use your own custom uuid, if required
    uuid = pubnub.uuid();
    SharedPreferences.Editor editor = sharedPrefs.edit();    
    editor.putString(getString(R.string.pn_uuid), uuid);
    editor.commit();
}

// set the uuid for the pubnub object
pubnub.setUUID(uuid);