class AnnotationRegistry {
    public static void register(String pattern, TownyChatReplacerCallable handler) {}

    public static void register(Class<?> clazz) {
        // only fields declared by this class, not inherited ones (static fields can't be inherited)
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            // must have that annotation
            PatternHandler annotation = field.getAnnotation(PatternHandler.class);
            if (annotation != null) {
                // must be static
                if (!Modifier.isStatic(field.getModifiers())) {
                    System.out.println("Field must be static:" + field.getName());
                    continue;
                }
                // get content of that field
                try {
                    Object object = field.get(null);
                    // must be != null and a callable
                    if (object instanceof TownyChatReplacerCallable) {
                        register(annotation.value(), (TownyChatReplacerCallable) object);
                    } else {
                        System.out.println("Field must be instanceof TownyChatReplacerCallable:"  + field.getName());
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}