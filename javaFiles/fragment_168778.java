private Class<? extends AbstractClass> classType;

private Types(Class<? extends AbstractClass> classType) {
   this.classType = classType;
}

public Class<? extends AbstractClass> getClassType() {
   return this.classType;
}