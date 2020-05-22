public class MyApplet extends JApplet {
    private IHelper pHelper = null;
    private MyReturnedInfo pInfo = null;

    public void init() {
        // Read the AppletReady parameter as passed from JavaScript
        String paramKey = "AppletReady";
        String jsLoadedCallback = this.getParameter(paramKey);

        // Load the library and get the information
        pHelper = (IHelper)Native.loadLibrary("Helper", IHelper.class);
        if (pHelper != null) {
            pInfo = pHelper.GetInfo();
            if (pInfo != null && jsLoadedCallback != null) {
                // Get the window which contains "this" applet
                JSObject jsObject = JSObject.getWindow(this);

                // Call the provided JavaScript function.
                // You can use as many parameters as you need.
                jsObject.call(jsLoadedCallback, new Object[] {
                        pInfo.MyInfoString.toString(),
                        pInfo.SomeOtherStringMaybe.toString()
                });
            }
        }
    }
}