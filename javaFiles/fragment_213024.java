private static boolean _matches(Class inputParam, Class<?> declaredArgumentParam) {
    boolean matches = true;
    if (!declaredParam.isAssignableFrom(inputParam)) {
        if(
            (inputParam.isPrimitive() && Primitives.wrap(inputParam) == declaredArgumentParam) ||
            (declaredArgumentParam.isPrimitive() && Primitives.wrap(declaredArgumentParam) == inputParam)
            ){
        }else{
            matches = false;
        }
    }
    return matches;
}