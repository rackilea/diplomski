public class MyApplet extends JApplet {

    @Override
    public void start() {
        // It will work if your applet is signed
        callWebService();
    }

    public void methodCalledFromJavascriptWrong() {
        // It will NOT work even if your applet is signed
        callWebService();

    }

    public void methodCalledFromJavascriptGood() {
        AccessController.doPrivileged(new PrivilegedAction() {

            public Object run() {
                // It will work if your applet is signed
                callWebService();
                return null;
            }

        });

    }

    private void callWebService() {
        //Here you call your web service
    }
}