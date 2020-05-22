public void methods(Class cl) {
    // Get the Methods of the Class cl
    Method[] me = cl.getDeclaredMethods();

    for (Method x : me) {
        String parameterType = "";
        System.out.println(x);
        Class[] parameterTypes = x.getParameterTypes();
        for (Class c : parameterTypes)
        parameterType = parameterType + c.getSimpleName() + " ,";

        System.out.println(x.getModifiers() + " " + x.getReturnType().getSimpleName() + " " + x.getName() + " ( "
            + parameterType + " )");
    }
    }