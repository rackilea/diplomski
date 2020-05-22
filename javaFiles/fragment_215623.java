@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@interface NativeFunctionName {
    String name() default "";
}

class FunctionNameAnnotationMapper implements FunctionMapper {
    @Override
    public String getFunctionName(NativeLibrary nativeLibrary, Method method) {
        NativeFunctionName annotation = method.getAnnotation(NativeFunctionName.class);
        // just return the function's name if the annotation is not applied
        return annotation == null ? method.getName() : annotation.name();
    }
}