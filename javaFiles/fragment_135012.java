Attaching to process ID 574, please wait...
Exception in thread "main" java.lang.reflect.InvocationTargetException
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:498)
        at sun.tools.jstack.JStack.runJStackTool(JStack.java:140)
        at sun.tools.jstack.JStack.main(JStack.java:106)
Caused by: java.lang.RuntimeException: gHotSpotVMStructs was not initialized properly in the remote process; can not continue
        at sun.jvm.hotspot.HotSpotTypeDataBase.readVMStructs(HotSpotTypeDataBase.java:418)
        at sun.jvm.hotspot.HotSpotTypeDataBase.<init>(HotSpotTypeDataBase.java:91)
        at sun.jvm.hotspot.HotSpotAgent.setupVM(HotSpotAgent.java:395)
        at sun.jvm.hotspot.HotSpotAgent.go(HotSpotAgent.java:305)
        at sun.jvm.hotspot.HotSpotAgent.attach(HotSpotAgent.java:140)
        at sun.jvm.hotspot.tools.Tool.start(Tool.java:185)
        at sun.jvm.hotspot.tools.Tool.execute(Tool.java:118)
        at sun.jvm.hotspot.tools.JStack.main(JStack.java:92)
        ... 6 more