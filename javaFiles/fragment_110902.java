@Pointcut(
    "execution(@com.xxx.xxx.annotation.MyAnnotationForMethod * *(.., @com.xxx.xxx.annotation.MyAnnotationForParam (*), ..))")
public void annotatedMethod(){}

@Before("annotatedMethod()")
public void doStuffOnParam(final JoinPoint jp){
    final Signature signature = jp.getSignature();
    if(signature instanceof MethodSignature){
        final MethodSignature ms = (MethodSignature) signature;

        final Method method = ms.getMethod();
        final String[] parameterNames = ms.getParameterNames();
        final Class<?>[] parameterTypes = ms.getParameterTypes();
        final Annotation[][] parameterAnnotations =
            method.getParameterAnnotations();
        for(int i = 0; i < parameterAnnotations.length; i++){
            final Annotation[] annotations = parameterAnnotations[i];
            final MyAnnotationForParam paramAnnotation =
                getAnnotationByType(annotations, MyAnnotationForParam.class);
            if(paramAnnotation != null){
                this.processParameter(ms.toShortString(),
                    parameterNames[i],
                    parameterTypes[i],
                    paramAnnotation);
            }

        }
    }
}

/**
 * In an array of annotations, find the annotation of the specified type, if any.
 * @return the annotation if available, or null
 */
@SuppressWarnings("unchecked")
private static <T extends Annotation> T getAnnotationByType(final Annotation[] annotations,
    final Class<T> clazz){

    T result = null;
    for(final Annotation annotation : annotations){
        if(clazz.isAssignableFrom(annotation.getClass())){
            result = (T) annotation;
            break;
        }
    }
    return result;
}

/**
 * Do some processing based on what we found.
 * @param signature method signature
 * @param paramName parameter name
 * @param paramType parameter type
 * @param paramAnnotation annotation we found
 */
private void processParameter(final String signature,
    final String paramName,
    final Class<?> paramType,
    final MyAnnotationForParam paramAnnotation){

    System.out.println(MessageFormat.format(
        "Found parameter ''{0}'' \n  of type ''{1}'' \n  with annotation ''{2}'' \n  in method ''{3}''",
        paramName,
        paramType,
        paramAnnotation,
        signature));
}