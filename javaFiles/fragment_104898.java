public void sendGlobalIntent(Intent intent,String[] requiredPermissions) {
    try {
        Class<?> cActivityManagerNative = Class
                .forName("android.app.ActivityManagerNative");
        Method mGetDefault = cActivityManagerNative.getMethod("getDefault");
        mGetDefault.setAccessible(true);
        Object oActivityManagerNative = mGetDefault.invoke(null);
        Method[] methods = cActivityManagerNative.getMethods();
        Method m = null;
        for (Method method : methods) {
            if (m.getName().equals("broadcastIntent")) {
                m = method;
            }
        }
        if (m == null) {
            return;
        }
        m.setAccessible(true);
        m.invoke(oActivityManagerNative, null, intent, null, null, 0, null,
                null, requiredPermissions, -1, null, true, false, android.os.Process.myUid() / 100000);

    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (NoSuchMethodException e) {
        e.printStackTrace();
    } catch (IllegalArgumentException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (InvocationTargetException e) {
        e.printStackTrace();
    }
}