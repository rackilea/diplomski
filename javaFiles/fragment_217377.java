public VanillaAppender createAppender() throws IOException {
    WeakReference<VanillaAppender> ref = appenderCache.get();
    VanillaAppender appender = null;
    if (ref != null)
        appender = ref.get();
    if (appender == null) {
        appender = createAppender0();
        appenderCache.set(new WeakReference<VanillaAppender>(appender));
    }
    return appender;
}