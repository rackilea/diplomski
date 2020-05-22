Class clazz = Meta.class;
ClassLoader classLoader = clazz.getClassLoader();    
Annotation annotation = clazz.getAnnotation(SomeAnnotation.class);
if (annotation instanceof SomeAnnotation) {
   classLoader.loadClass("Meta");
}