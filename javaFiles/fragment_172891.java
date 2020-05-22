05-18 18:29:44.160: ERROR/AndroidRuntime(2145): FATAL EXCEPTION: main
05-18 18:29:44.160: ERROR/AndroidRuntime(2145): java.lang.RuntimeException: Unable to start activity ComponentInfo{com.paad.whereami/com.paad.whereami.WhereAmI}: java.lang.NullPointerException
05-18 18:29:44.160: ERROR/AndroidRuntime(2145):     at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:1647)
05-18 18:29:44.160: ERROR/AndroidRuntime(2145):     at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:1663)
05-18 18:29:44.160: ERROR/AndroidRuntime(2145):     at android.app.ActivityThread.access$1500(ActivityThread.java:117)
05-18 18:29:44.160: ERROR/AndroidRuntime(2145):     at android.app.ActivityThread$H.handleMessage(ActivityThread.java:931)
05-18 18:29:44.160: ERROR/AndroidRuntime(2145):     at android.os.Handler.dispatchMessage(Handler.java:99)
05-18 18:29:44.160: ERROR/AndroidRuntime(2145):     at android.os.Looper.loop(Looper.java:130)
05-18 18:29:44.160: ERROR/AndroidRuntime(2145):     at android.app.ActivityThread.main(ActivityThread.java:3683)
05-18 18:29:44.160: ERROR/AndroidRuntime(2145):     at java.lang.reflect.Method.invokeNative(Native Method)
05-18 18:29:44.160: ERROR/AndroidRuntime(2145):     at java.lang.reflect.Method.invoke(Method.java:507)
05-18 18:29:44.160: ERROR/AndroidRuntime(2145):     at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:839)
05-18 18:29:44.160: ERROR/AndroidRuntime(2145):     at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:597)
05-18 18:29:44.160: ERROR/AndroidRuntime(2145):     at dalvik.system.NativeStart.main(Native Method)
05-18 18:29:44.160: ERROR/AndroidRuntime(2145): Caused by: java.lang.NullPointerException
05-18 18:29:44.160: ERROR/AndroidRuntime(2145):     at com.example.project.MainActivity.updateWithNewLocation(MainActivity.java:290)
05-18 18:29:44.160: ERROR/AndroidRuntime(2145):     at com.example.project.MainActivity.onCreate(MainActivity.java:216)
05-18 18:29:44.160: ERROR/AndroidRuntime(2145):     at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1047)
05-18 18:29:44.160: ERROR/AndroidRuntime(2145):     at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:1611)