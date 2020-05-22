List<Method> list = new ArrayList<Method>();
    for (Object obj : vector) {
        if (obj instanceof Method) {
            list.add(obj);
        }
    }