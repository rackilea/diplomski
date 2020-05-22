public PluginResult execute(String action, JSONArray data, String callbackId) {
    PluginResult result = null;
    if (PRINT_ACTION.equals(action))
    {
        JSONObject printerStatusJSON = new JSONObject();
        try {
            Boolean prtStatus = false;
            String msg ="Failed to connect to printer";
            String portName = "";
            ArrayList<PortInfo> dvss = PrinterFunctions.getDevices();//BTPortList  = StarIOPort.searchPrinter("BT:");

            if (Looper.myLooper() == null) {
                Looper.prepare();
            }

            for(PortInfo dvs : dvss) {
                Map<String, String> st = PrinterFunctions.CheckStatus(dvs.getPortName(), "mini");//port = StarIOPort.getPort(portName, portSettings, 1000);
                if(st.get("status") == "true") {
                    prtStatus = true;
                    portName = st.get("portName"); 
                    break;
                }
                msg = st.get("message");
            }

            if(!portName.isEmpty()) {
                PrinterFunctions.PrintSomething(portName, data);//MiniPrinterFunctions.PrintSampleReceipt(String portName, JSONArray data);
            }

            printerStatusJSON.put("prtStatus", prtStatus);
            printerStatusJSON.put("message", msg);

            result = new PluginResult(Status.OK, printerStatusJSON);
        } 
        catch (Exception jsonEx) {
            Log.e("YourApplicationName", "Got JSON Exception " + jsonEx.getMessage());
            jsonEx.printStackTrace();
            result = new PluginResult(Status.JSON_EXCEPTION);
        }
    }
    else {
        result = new PluginResult(Status.INVALID_ACTION);
        Log.e(TAG, "Invalid action : " + action);
    }
    return result;
}