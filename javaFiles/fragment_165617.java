MyClassJSO jso = MyClassJSO.createInstance();

public static native MyClassJSO createInstance() /*-{
    return new MyObjectFromJavaScript;//or whatever you need to do 
    //in JS to create the object
}-*/;