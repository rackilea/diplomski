public Dog getSelf() {
    Class<? extends Dog> thisClass = this.getClass();
    try {
        return thisClass.newInstance();
    } catch (InstantiationException e) {
    } catch (IllegalAccessException e) {
    }
    throw new UnsupportedOperationException(thisClass 
                         + " does not supply a public no-arg constructor");
}