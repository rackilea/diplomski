CtNewClass(String name, ClassPool cp, boolean isInterface, CtClass superclass) {
    super(name, cp);
    this.wasChanged = true;
    String superName;
    if (!isInterface && superclass != null) {
        superName = superclass.getName();
    } else {
        superName = null;
    }

    this.classfile = new ClassFile(isInterface, name, superName);
    if (isInterface && superclass != null) {
        this.classfile.setInterfaces(new String[]{superclass.getName()});
    }

    this.setModifiers(Modifier.setPublic(this.getModifiers()));
    this.hasConstructor = isInterface;
}