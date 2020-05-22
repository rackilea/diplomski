ObjType obj = /*...*/;
handleObj(obj, SubObjType.class);

// ...

private <T extends ObjType> void handleObj(ObjType obj,
                                           ObjectHandle<T> handle,
                                           Class<T> handleableObjClass) {
    if (handleableObjClass.isInstance(obj)) {
        handle.setObj(handleableObjClass.cast(obj));
    }
}