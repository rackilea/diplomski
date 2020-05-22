ReqDto object = ...; // get instance
Class<?> clazz = object.getClass(); get actual type of the instance

for(Annotation annotation : clazz.getAnnotations()) { // these are class annotations
    System.out.println(annotation.toString());
}