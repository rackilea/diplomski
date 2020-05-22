try {
    Method getRadioVersion = Build.class.getMethod("getRadioVersion");
    if (getRadioVersion != null) {
        try {
            String version = (String) getRadioVersion.invoke(Build.class);
            // Add your implementation here
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } else {
        Log.wtf(TAG, "getMethod returned null");
    }
} catch (NoSuchMethodException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}