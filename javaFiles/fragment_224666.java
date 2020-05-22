public static Method findMethod(Class<?> cls, String name, Class<?>[] fa) {
    System.out.println("Checking class " + cls + " for method " + name);
    // since it is called recursively, we want to stop some day, and when we are
    // passed null (so most getSuperclass was called on Object.class or something similar)
    if (cls == null) {
        return null;
    }
    Method m = null;
    if ((m = findMethod(cls.getSuperclass(), name, fa)) != null) {
        return m;
    }
    // ok, if we're here, then m is null. so check if cls is public. it must be public, because
    // otherwise we won't be able to call it - we are definitely in different package. if class
    // isn't public, then check interfaces.
    if (!Modifier.isPublic(cls.getModifiers())) {
        System.out.println("Class is not public, and superclasses do not contain method " + name);
        System.out.println("Checking all interfaces");
        for (Class<?> iface: cls.getInterfaces()) {
            if ((m = findMethod(iface, name, fa)) != null) {
                return m;
            }
        }
    }
    return findMethodInClass(cls, name, fa);
}
private static Method findMethodInClass(Class<?> cls, String name, Class<?>[] fa) {
    Method m = null;
    // scan all methods and move plausible candidates to the start of an array
    Method[] mm = cls.getMethods(); 
    int n = 0;
    for (int i = 0 ; i < mm.length ; ++i) {
        if (checkMethod(mm[i], name, fa)) {
            mm[n++] = mm[i];
        }
    }
    if (n > 1) {
        System.out.println("Caveat: we have to perform more specific test. n == " + n);
        System.out.println("class: " + cls + "\nname: " + name);
        for (int i = 0 ; i < n ; ++i) {
            System.out.println(mm[i]);
        }
    }
    if (n > 0) {
        m = mm[0];
    }
    return m;
}