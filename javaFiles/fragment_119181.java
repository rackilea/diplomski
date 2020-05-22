public class MyPlugin extends CordovaPlugin {
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        String myString = "Some string";
        callbackContext.success(myString);
        return true;
    }
}