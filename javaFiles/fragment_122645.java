String serial = null;       
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
        serial = Build.SERIAL;
    } else {
        try {
             Class<?> c = Class.forName("android.os.SystemProperties");
             Method get = c.getMethod("get", String.class);
             serial = (String) get.invoke(c, "ro.serialno");
         } catch (Exception ignored) {
         }
    }