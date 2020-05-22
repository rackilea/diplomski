// If generics involved in method signature:
Type[] paramTypes = method.getGenericParameterTypes(); 
Type returnType = method.getGenericReturnType(); 
// Note: if Class is non-static inner class, first parameter of 
// getGenericParameterTypes() is the enclosing class

// If no generics involved in method signature:
Class<?>[] paramTypes = declaredMethod.getParameterTypes(); 
Class<?> returnType = declaredMethod.getReturnType(); 
// Note: if Class is non-static inner class, first parameter of 
// getParameterTypes() is the enclosing class

// Same method calls for declaredConstructor