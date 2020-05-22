public <T> T getObject(String json, SomeObject<T> someObjectWithGenericType) {
    Class cl = getTypeClassOfObject(someObjWithGenericType);
    T object = gson.fromJson(json, new Element<T>(cl));
    return object;
}

private Class getTypeClassOfObject(Object obj) {
    return (Class) ((ParameterizedType) obj.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
}

private class Element<T> implements ParameterizedType {

    private Class<T> cl;

    public Element(Class<T> cl) {
        this.cl = cl;
    }

    public Type[] getActualTypeArguments() {
        return new Type[] {cl};
    }

    public Type getRawType() {
        return cl;
    }

    public Type getOwnerType() {
        return null;
    }
}