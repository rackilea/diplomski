public static void main(String[] args) throws Exception {
    System.out.println(F.class.getField("a").getModifiers());
    JavaClass aClass = Repository.lookupClass(F.class);
    ClassGen aGen = new ClassGen(aClass);
    for (Field field : aGen.getFields()) {
        if (field.getName().equals("a")) {
            int mods = field.getModifiers();
            field.setModifiers(mods | Modifier.FINAL);
        }
    }
    final byte[] classBytes = aGen.getJavaClass().getBytes();
    ClassLoader cl = new ClassLoader(null) {
        @Override
        protected synchronized Class<?> findClass(String name) throws ClassNotFoundException {
            return defineClass("F", classBytes, 0, classBytes.length);
        }
    };
    Class<?> fWithoutDeprecated = cl.loadClass("F");
    System.out.println(fWithoutDeprecated.getField("a").getModifiers());
}