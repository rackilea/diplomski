org.alljoyn.bus.alljoyn.DaemonInit.PrepareDaemon(getApplicationContext());

//Bus Connection
Status status = mBus.connect();

//Check if connection is established
if (status != Status.OK) {
    return;
}

//Setup Bus Attachment
mBus.useOSLogging(true);
mBus.setDebugLevel("ALLJOYN_JAVA", 7);
mBus.registerAboutListener(mListener);

//Start AboutData Listener
status = mBus.whoImplements(null);

if (status != Status.OK) {
    Log.e(TAG, "whoImplements Error");
} else {
    Log.w(TAG, "whoImplements Success");
}