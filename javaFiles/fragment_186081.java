@MyAnnotation(clazz=String.class, method="contains", params= {CharSequence.class})

@interface MyAnnotation {
   Class<?> clazz();
   String method();
   Class<?>[] params() default {};
}

MyAnnotation annotation = // get the annotation
annotation.clazz().getMethod(annotation.method(), annotation.params());