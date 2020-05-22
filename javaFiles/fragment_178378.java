ClassPool pool = ClassPool.getDefault();
    CtClass sp = pool.get("SomeProcess");
    for (CtMethod m : sp.getDeclaredMethods()) {
        if (m.hasAnnotation(ToBeTransformed.class)) {
            String body = // create new body 
            m.setBody(body);
        }
    }