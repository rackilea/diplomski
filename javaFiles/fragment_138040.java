01 - 25 11: 37: 40.620 29867 - 29867 / ? E / AndroidRuntime : FATAL EXCEPTION: main
    Process: com.sosisvesalam.kefelon.sossvesalam, PID: 29867
    java.lang.RuntimeException: Unable to start activity ComponentInfo {
        com.sosisvesalam.kefelon.sossvesalam / com.sosisvesalam.kefelon.sossvesalam.MainActivity
    }: android.view.InflateException: Binary XML file line #0: Error inflating class android.widget.GridLayout
at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2335)
at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2397)
at android.app.ActivityThread.access$800(ActivityThread.java:151)
at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1310)
at android.os.Handler.dispatchMessage(Handler.java:102)
at android.os.Looper.loop(Looper.java:135)
at android.app.ActivityThread.main(ActivityThread.java:5268)
at at java.lang.reflect.Method.invoke(Method.java:372)
at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:902)
at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:697)
Caused by: android.view.InflateException: Binary XML file line # 0: Error inflating class android.widget.GridLayout
    at android.view.LayoutInflater.createView(LayoutInflater.java: 633)
...
"com.sosisvesalam.kefelon.sossvesalam:drawable/board" (7f060053)  is not a Drawable (color or path): TypedValue{t=0x1/d=0x7f060053 a=-1 r=0x7f060053}