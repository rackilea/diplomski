private static final long sel_requestUserAttention_ = OS.sel_registerName("requestUserAttention:");

private static final int NSCriticalRequest = 0;
private static final int NSInformationalRequest = 10;

...

NSApplication app = NSApplication.sharedApplication();

OS.objc_msgSend(app.id, sel_requestUserAttention_, NSInformationalRequest);