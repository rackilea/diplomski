Error Message:
    java.lang.StringIndexOutOfBoundsException: length=28; regionStart=1;
    regionLength=499 at java.lang.String.substring(String.java:1931) at     
    com.example.my.app.MainActivity$2.onResponse(MainActivity.java:50) at     
    com.example.my.app.MainActivity$2.onResponse(MainActivity.java:46) at     
    com.android.volley.toolbox.StringRequest.deliverResponse(StringRequest.java:60) at     
    com.android.volley.toolbox.StringRequest.deliverResponse(StringRequest.java:30) at     
    com.android.volley.ExecutorDelivery$ResponseDeliveryRunnable.run(ExecutorDelivery.java:99) at android.os.Handler.handleCallback(Handler.java:751) at     
    android.os.Handler.dispatchMessage(Handler.java:95) at     
    android.os.Looper.loop(Looper.java:154) at     
    android.app.ActivityThread.main(ActivityThread.java:6077) at     
    java.lang.reflect.Method.invoke(Native Method) at     
    com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:865) at     
    com.android.internal.os.ZygoteInit.main(ZygoteInit.java:755)