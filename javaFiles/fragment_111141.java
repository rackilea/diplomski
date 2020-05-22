MethodHandle mh; // a MethodHandle Object
Class<?> mhn;
    try {
        mhn = Class.forName("java.lang.invoke.MethodHandleNatives");
        Constructor<?> con = mhn.getDeclaredConstructor();
        con.setAccessible(true);
        Object mhnInstance = con.newInstance();
        Method getTargetMethod = mhn.getDeclaredMethod("getTargetMethod", new Class<?>[]{MethodHandle.class});
        getTargetMethod.setAccessible(true);
        Method inside = (Method) getTargetMethod.invoke(mhnInstance, mh);
        System.out.println("INSIDE = " + inside.toGenericString());

    } catch (Throwable e) {
        e.printStackTrace();
    }