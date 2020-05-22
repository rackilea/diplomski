java.lang.invoke.MethodType mt; 
java.lang.invoke.MethodHandle mh;
java.lang.invoke.MethodHandles.Lookup lookup = MethodHandles.lookup();

// process methods
for (java.lang.reflect.Method method: declaredMethods) {
    mh = lookup.unreflect(method);

    // can call mh.invokeExact (requiring first parameter to be the class' 
    // object instance upon which the method will be invoked, followed by 
    // the methodparameter types, with an exact match parameter and return 
    // types) or
    // mh.invoke/invokeWithArguments (requiring first parameter to be the 
    // class' object instance upon which the method will be invoked, 
    // followed by the method parameter types, with compatible conversions 
    // performed on input/output types)
}

// process constructors
for (java.lang.reflect.Constructor<?> constructor: declaredConstructors) {
    mh = lookup.unreflectConstructor(constructor);

    // can call mh.invokeExact or
    // mh.invoke/invokeWithArguments 
}

// process field setters
for (java.lang.reflect.Field field: declaredFields) {
    mh = lookup.unreflectSetter(field);

    // can call mh.invokeExact or
    // mh.invoke/invokeWithArguments 
}

// process field getters
for (java.lang.reflect.Field field: declaredFields) {
    mh = lookup.unreflectGetter(field);

    // can call mh.invokeExact or
    // mh.invoke/invokeWithArguments 
}