public <T> List<T> getList(String json, SomeObject<T> someObjectWithGenericType) {
    Class cl = getTypeClassOfObject(someObjWithGenericType);
    List<T> list = gson.fromJson(json, new ListWithElements<T>(cl));
    return list;
}

private class ListWithElements<T> implements ParameterizedType {

    private Class<T> elementsClass;

    public ListWithElements(Class<T> elementsClass) {
        this.elementsClass = elementsClass;
    }

    public Type[] getActualTypeArguments() {
        return new Type[] {elementsClass};
    }

    public Type getRawType() {
        return List.class;
    }

    public Type getOwnerType() {
        return null;
    }
}