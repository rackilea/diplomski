public static native void executeFunctionWithCallBack(MyCallback callback)/*-{
           var callBackWrapper =function(param) {
              callback.@com.package.MyObject::onSuccess(*)(param);
           } 
           $wnd.invokeFunctionWithCallback(callbackWrapper)  
     }-*/;