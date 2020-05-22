public class MyApplet extends JApplet {
    private IHelper pHelper = null;
    private MyReturnedInfo pInfo = null;

    public void init() {
        pHelper = (IHelper)Native.loadLibrary("Helper", IHelper.class);
        if (pHelper != null) {
            pInfo = pHelper.GetInfo();
        }
    }

    public String GetInfoString() {
        if (pInfo != null) {
            // need to call toString to convert from native wide char to something JavaScript will be able to interpret
            return pInfo.MyInfoString.toString(); 
        }
        return null;
    }
}