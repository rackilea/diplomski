public class CaseInsensitiveSetter {

    public static Setter getSetter(Class<?> theClass, String propertyName) {

        Setter setter;

        if (theClass == Object.class || theClass == null) {
            setter = null;
        } else {
            setter = doGetSetter(theClass, propertyName);

            if (setter != null) {
                if (!ReflectHelper.isPublic(theClass, setter.getMethod())) {
                    setter.getMethod().setAccessible(true);
                }
            } else {
                setter = doGetSetter(theClass.getSuperclass(), propertyName);
                if (setter == null) {
                    Class<?>[] interfaces = theClass.getInterfaces();
                    for (int i = 0; setter == null && i < interfaces.length; i++) {
                        setter = doGetSetter( interfaces[i], propertyName);
                    }
                }
            }
            if (setter == null) {
                throw new PropertyNotFoundException( 
                    "Could not find a setter for property " + 
                    propertyName + " in class " + theClass.getName());
            }
        }
        return setter;
    }

    // The actual work is done here
    private static Setter doGetSetter(Class<?> resultClass, String propertyName) {

        Method[] methods = resultClass.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            // only carry on if the method has 1 parameter
            if ( methods[i].getParameterTypes().length == 1 ) {
                String methodName = methods[i].getName();

                if (methodName.startsWith("set")) {
                    String testStdMethod = methodName.substring(3);
                    if (testStdMethod.equalsIgnoreCase(propertyName)) {
                        Setter result = new CustomSetter(
                            resultClass, methods[i], propertyName);
                        return result;
                    }
                }
            }
        }
        return null;
    }
}