public static Object genericInvokMethod(Object obj, String methodName, Object[] formalParams, Object[] actualParams) {
    Method method;
    Object requiredObj = null;

    try {
        method = obj.getClass().getDeclaredMethod(methodName, formalParams);
        method.setAccessible(true);
        requiredObj = method.invoke(obj, actualParams);
    } catch (NoSuchMethodException e) {
        e.printStackTrace();
    } catch (IllegalArgumentException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (InvocationTargetException e) {
        e.printStackTrace();
    }

    return requiredObj;
}