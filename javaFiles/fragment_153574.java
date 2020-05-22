//in onCreate 
appView.addJavascriptInterface(new MyJSInterface(),
            "myJSInterface");
super.loadUrl("file:///android_asset/www/index.html");


//JSInterface class
public class MyJSInterface {

    public MyJSInterface() {
        // TODO Auto-generated constructor stub
        Log.i(TAG, "constructor of jsinterface");
    }

    public void btnClick () {
        //do something
    }
}