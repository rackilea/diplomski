ObjDate getSortingDate(Obj obj) {
    if (obj.getObjectType().getId() == 1) {
        return obj.getObject().getTable1().getTime();
    } else {
        return obj.getObject().getTable2().getTime();
    }
}