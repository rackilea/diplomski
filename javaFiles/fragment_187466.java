package XXXXX.client;

import com.google.gwt.core.client.EntryPoint;

class _24_TestJSNIMethodCallback implements EntryPoint {
    public void onModuleLoad() {
        drawJSChart();
    }

    public String getNameToShow() {
        return "Chart number 1";
    }

    public native void drawJSChart() /*-{
        try {
            //First create a script where to paste the jsData 
            var scriptID = this
                    .@XXXXX.client._24_TestJSNIMethodCallback::getNameToShow()();
            $wnd.alert(scriptID);
            //Some code 
        } catch (e) {
            console.error(e.message);
        }
    }-*/;

}