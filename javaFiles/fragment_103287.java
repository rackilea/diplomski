if (Integer.valueOf(android.os.Build.VERSION.SDK_INT) >= 9) {
        try {
            // StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
            Class<?> strictModeClass = Class.forName("android.os.StrictMode", true, Thread.currentThread()
                    .getContextClassLoader());
            Class<?> threadPolicyClass = Class.forName("android.os.StrictMode$ThreadPolicy", true, Thread.currentThread()
                    .getContextClassLoader());
            Field laxField = threadPolicyClass.getField("LAX");
            Method setThreadPolicyMethod = strictModeClass.getMethod("setThreadPolicy", threadPolicyClass);
            setThreadPolicyMethod.invoke(strictModeClass, laxField.get(null));
        } catch (Exception e) {
        }
    }