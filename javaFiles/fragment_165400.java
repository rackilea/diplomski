public static void setOpaque(Window window, boolean opaque) {
    try {
        Class<?> awtUtilsClass = Class.forName("com.sun.awt.AWTUtilities");
        if (awtUtilsClass != null) {
            Method method = awtUtilsClass.getMethod("setWindowOpaque", Window.class, boolean.class);
            method.invoke(null, window, opaque);
        }
    } catch (Exception exp) {
    }
}