private static <T> T cloneByReflection(T object) {
    try {
        return (T) object.getClass().getMethod("clone").invoke(object);
    } catch (Exception e) {
        return null;    // or whatever you want to do
    }
}

public static <T> void fillWithClones(T[] array, T template) {
    for (int i = 0; i < array.length; ++i)
        array[i] = cloneByReflection(template);
}