private static final Selector beginBackgroundTaskWithExpirationHandler$ = Selector.register("beginBackgroundTaskWithExpirationHandler:");
@Bridge private native static int objc_beginBackgroundTask(UIApplication __self__, Selector __cmd__, ObjCBlock handler);
@Bridge private native static int objc_beginBackgroundTaskSuper(ObjCSuper __super__, Selector __cmd__, ObjCBlock handler);
public int beginBackgroundTask(VoidBlock handler) {
    return beginBackgroundTask(VoidBlock.Marshaler.toObjCBlock(handler));
}
protected int beginBackgroundTask(ObjCBlock handler) {
    if (customClass) { return objc_beginBackgroundTaskSuper(getSuper(), beginBackgroundTaskWithExpirationHandler$, handler); } else { return objc_beginBackgroundTask(this, beginBackgroundTaskWithExpirationHandler$, handler); }
}