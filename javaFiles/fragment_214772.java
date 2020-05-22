Log.d(LOG_TAG, "Setting proxy with >= 4.4 API.");

    Context appContext = webView.getContext().getApplicationContext();
    System.setProperty("http.proxyHost", host);
    System.setProperty("http.proxyPort", port + "");
    System.setProperty("https.proxyHost", host);
    System.setProperty("https.proxyPort", port + "");
    try {
        Field loadedApkField = appContext.getClass().getField("mLoadedApk");
        loadedApkField.setAccessible(true);
        Object loadedApk = loadedApkField.get(appContext);
        Class loadedApkCls = Class.forName("android.app.LoadedApk");
        Field receiversField = loadedApkCls.getDeclaredField("mReceivers");
        receiversField.setAccessible(true);
        ArrayMap receivers = (ArrayMap) receiversField.get(loadedApk);
        for (Object receiverMap : receivers.values()) {
            for (Object rec : ((ArrayMap) receiverMap).keySet()) {
                Class clazz = rec.getClass();
                if (clazz.getName().contains("ProxyChangeListener")) {
                    Method onReceiveMethod = clazz.getDeclaredMethod("onReceive", Context.class, Intent.class);
                    Intent intent = new Intent(Proxy.PROXY_CHANGE_ACTION);

                    onReceiveMethod.invoke(rec, appContext, intent);
                }
            }
        }

        Log.d(LOG_TAG, "Setting proxy with >= 4.4 API successful!");
        return true;