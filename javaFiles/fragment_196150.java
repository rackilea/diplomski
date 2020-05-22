Class<?> clazz = ..; //get the class
    Method m = null;
    do {
        m = findMethodWithAnnotation(clazz, DesiredAnnotation.class);
        clazz = clazz.getSuperclass();
    } while (m == null && clazz != null);
    System.out.println(m);