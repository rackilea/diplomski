Method m = MyClass.class.getMethod("someMethodWithParamAnnotations", String.class, String.class);
Annotation[][] paramAnnotations = m.getParameterAnnotations();
Annotation[] firstParamAnnotation = paramAnnotations[0]; 
// Above is empty array, since first parameter has no annotation

Annotation[] secondParamAnnotation = paramAnnotations[1]; 
// Above contains an array with the `@MyAnnotation` annotation