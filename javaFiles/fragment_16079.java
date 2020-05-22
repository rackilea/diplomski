class ObjectHandle<T extends ObjType> {

    T obj;

    private final Class<T> objectClass;

    ObjectHandle(Class<T> cls) {
        objectClass = Objects.requireNonNull(cls);
    }

    Class<T> getObjectClass() {
        return objectClass;
    }

    void setObj(T o) {
        obj = o;
    }
}

// ...
ObjectHandle<SubObjType> handle = new ObjectHandle<SubObjType>();
// ...

ObjectType obj = /*...*/;
if (handle.getObjectClass().isInstance(obj)) {
    handle.setObj(handle.getObjectClass().cast(obj));
}