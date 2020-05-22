class GenericService<T> {
    Class<T> entityClass;
    public void setEntityClass(Class<T> clazz) {
        this.entityClass = clazz;
    }
    ....
 }