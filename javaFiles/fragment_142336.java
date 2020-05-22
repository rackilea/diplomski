//Create Java variables
public static int myValueResult = 0;
public static string myValueName = "";

// Called to emit events to event listeners in JS
private void sendEvent(String eventName, int result) {
getReactApplicationContext()
        //JS Method
        .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
        .emit(eventName, result);

        //Add an extra line that saves the result and eventName to the Java variables we made 
        myValueResult = result;
        myValueName = eventName;
}