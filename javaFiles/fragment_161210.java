SubTypesScanner sts = new SubTypesScanner(false); /* false means include direct Object subtypes in results.*/
Reflections reflections = new Reflections("Your.package.name", sts);
Set<Class<? extends Object>> classes = reflections.getSubTypesOf(Object.class);
for (Class<? extends Object> clazz : classes) {
    System.out.println(clazz);
}