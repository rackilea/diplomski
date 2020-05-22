public boolean isImplementor(final CtClass interfaceClass,
                             final CtClass clazz) throws NotFoundException {
    return isImplementor(interfaceClass, clazz.getInterfaces())
        || isImplementor(interfaceClass, clazz.getSuperclass());
}

private boolean isImplementor(final CtClass interfaceClass,
                              final CtClass[] interfaces) throws NotFoundException {
    for (final CtClass intf : interfaces) {
        if (intf == interfaceClass || isImplementor(interfaceClass, 
                                                    intf.getInterfaces())) {
            return true;
        }
    }
    return false;
}