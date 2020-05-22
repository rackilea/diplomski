@Override
protected Class<?> findClass(String name) throws ClassNotFoundException {
    byte[] b = classObjects.get(name);
    if (b == null) {
        Class<?> c = null;
        try {
            c = Class.forName(name);//Use a custom way to load the class
        } catch(ClassNotFoundException e) {
        }
        if(c == null) {
            return super.findClass(name);
        }
        return c;
    }
    return super.defineClass(name, b, 0, b.length, (CodeSource) null);
}