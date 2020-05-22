for(Class<?> cls : classesToCheck) {
    for(Method m : cls.getDeclaredMethods()) {
        if(!m.getName().equals(methodName))
            continue;
        if(m.getReturnType() != returnType)
            continue;

        Class<?>[] pams = m.getParameterTypes();
        if(pams.length != pamsToCheckFor.length)
            continue;

        int i;
        for(i = 0; i < pams.length; i++) {
            if(pams[i] != pamsToCheckFor[i])
                break;
        }

        if(i == pams.length)
            return m; // or return true
    }
}

// not found