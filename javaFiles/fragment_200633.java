public static Method findMethod(Object m, String methodName, Class[] paramsTypes) {
    Method[] metody = m.getClass().getDeclaredMethods();
    List<Method> sameNames = new ArrayList<Method>();
    // filter other names
    for (Method meth : metody) {
        if (meth.getName().equals(methodName)) {
            sameNames.add(meth);
        }
    }
    // lets find best candidate
    if (sameNames.isEmpty()) {
        return null;
    } else {
        // filter other count of parameters
        List<Method> sameCountOfParameters = new ArrayList<Method>();
        for (Method meth : sameNames) {
            if (meth.getParameterTypes().length == paramsTypes.length) {
                sameCountOfParameters.add(meth);
            }
        }
        if (sameCountOfParameters.isEmpty()) {
            return null;
        } else {
            for (Method meth : sameCountOfParameters) {
                // first one, which is suitable is the best
                Class<?>[] params = meth.getParameterTypes();
                boolean good = true;
                for (int i = 0; i < params.length && good; i++) {
                    if (params[i].isInterface() && Arrays.asList(paramsTypes[i].getInterfaces()).contains(params[i])) {
                        //if i-th paramater type is Interface and we search method with its implementation
                        good = true;
                        continue;
                    } else {
                        // if we call it with subclass and parameter typ is superclass
                        if (paramsTypes[i].getSuperclass().equals(params[i])) {
                            good = true;
                            continue;
                        }
                    }
                    good = false;
                }
                if (good) {
                    return meth;
                }
            }
        }
    }
    return null;
}