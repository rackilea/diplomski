// getting the SerializedLambda
public static SerializedLambda getSerializedLambda(Object function) {
    if (function == null || !(function instanceof java.io.Serializable)) {
        throw new IllegalArgumentException();
    }

    for (Class<?> clazz = function.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
        try {
            Method replaceMethod = clazz.getDeclaredMethod("writeReplace");
            replaceMethod.setAccessible(true);
            Object serializedForm = replaceMethod.invoke(function);

            if (serializedForm instanceof SerializedLambda) {
                return (SerializedLambda) serializedForm;
            }
        }
        catch (NoSuchMethodError e) {
            // fall through the loop and try the next class
        }
        catch (Throwable t) {
            throw new RuntimeException("Error while extracting serialized lambda", t);
        }
    }

    throw new Exception("writeReplace method not found");
}