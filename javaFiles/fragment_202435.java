public static <T extends Module> T initializeModule(Class<T> myClass) {
    T module = null;
    try {
        module = myClass.newInstance();
    } catch (SecurityException e) {
        throw new ModuleException(e);
    } catch (InstantiationException e) {
        throw new ModuleException(e);
    } catch (IllegalAccessException e) {
        throw new ModuleException(e);
    }
    return module;
}