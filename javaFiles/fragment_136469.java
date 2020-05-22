public void foo(Class<?> clazz) {
    Field[] fieldReflection = clazz.getDeclaredFields();

    for (Field fieldReflect : fieldReflection){
        FieldSize annotation = fieldReflect.getAnnotation(FieldSize.class);
        if (annotation != null){
            //do something
        } else {
            throw new Exception();
        }
    }
}