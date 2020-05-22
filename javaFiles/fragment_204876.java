<V> boolean hasInheritedDeclaredMethod(V value, String methodName)
{
    Class c = value.getClass();
    boolean hasMethod = false;
    while (!hasMethod && c != Object.class) {
        try { 
            Method m = c.getDeclaredMethod(methodName, null); 
            hasMethod = true;
        }
        catch (NoSuchMethodException e) {  }
        // you don't have access to the method from your package
        catch (SecurityException e) { break; }
        if (!hasMethod && c != Object.class)
            c = c.getSuperclass();
    }
    return hasMethod;
}