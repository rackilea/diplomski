public SomeConstr(int size) {
   this(size, Device.class);
}

public SomeConstr(int size, Class clazz) {
    if (size <= 0) {
        IllegalArgumentException argumentException = new IllegalArgumentException();
        logger.log(Level.SEVERE, "", argumentException);
        throw argumentException;
    }
    if (clazz == null || !Device.class.isAssignableFrom(clazz)) {
        logger.log(Level.SEVERE, "");
        throw new IllegalArgumentException();
    }
    this.size = size;
    this.clazz = clazz;
}