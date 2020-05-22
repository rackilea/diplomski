void compileAndLoad(List<ICompilable> compilables) {
    Map<String,byte[]> compiled = new HashMap<>(compilables.size());
    for(ICompilable c: compilables)
        compiled.put(c.getFullName(), genBytecode(c));
    ClassLoader l = new ClassLoader(CLASS_LOADER) {
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            byte[] code = compiled.get(name);
            if(code == null) throw new ClassNotFoundException(name);
            return defineClass(name, code, 0, code.length);
        }
    };
    // the code below this line is questionable; it seems you are relying
    // on the side effects of a class initializer
    for(String name: compiled.keySet()) try {
        Class.forName(name, true, l);
    } catch (ClassNotFoundException ex) { throw new AssertionError(ex); }
}