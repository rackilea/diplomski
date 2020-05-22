private final Class<T> clazz;

PropertyImplementationBinder(Class<T> clazz){
    this.clazz = clazz;
}

public Class<T> getInterfaceClass() {
    return clazz;
}