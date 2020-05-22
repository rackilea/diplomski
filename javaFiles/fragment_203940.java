class HeaderType {

    private int typeToClassId;

    public int getTypeToClassId() {
        return typeToClassId;
    }

    public void setTypeToClassId(int typeToClassId) {
        this.typeToClassId = typeToClassId;
    }

    @Override
    public String toString() {
        return "HeaderType [typeToClassId=" + typeToClassId + "]";
    }
}

class HeaderObject<T> {

    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "HeaderObject [obj=" + obj + "]";
    }
}