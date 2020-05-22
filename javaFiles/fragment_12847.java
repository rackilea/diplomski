public static void main(String[] args) throws IOException {
    ClassPath p = ClassPath.from(ClassLoader.getSystemClassLoader()); // might need to provide different ClassLoader
    ImmutableSet<ClassInfo> classes = p.getTopLevelClasses("com.example");

    for (ClassInfo classInfo : classes) {
        Class clazz = classInfo.load();
        int modifiers = clazz.getModifiers();
        if (Modifier.isAbstract(modifiers)) {
            System.out.println("Class '" + clazz.getName() + "' is abstract.");
        }
    }
}