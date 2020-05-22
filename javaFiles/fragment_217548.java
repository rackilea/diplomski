public boolean execute(String action, JSONArray data, CallbackContext callbackContext) {

    PluginResult result = null;
    try {
        Actions currentAction = Actions.valueOf(action.toUpperCase());
        JSONObject Resp = new JSONObject();
        String RespStr;
        switch(currentAction){
        case OPEN:
            //do work
            this.callbackContext.sendPluginResult(
                new PluginResult(PluginResult.Status.OK, results));
    } catch (JSONException jsonEx) {    
        System.out.println(jsonEx.toString());
        result = new PluginResult(Status.JSON_EXCEPTION);
    }
    return true;
}