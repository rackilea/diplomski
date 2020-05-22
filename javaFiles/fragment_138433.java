Constructor<MethodHandles.Lookup> constructor;
Class<?> declaringClass;
Object result;

if (method.isDefault()) {
   declaringClass = method.getDeclaringClass();
   constructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, int.class);

   constructor.setAccessible(true);

   result = constructor.
      newInstance(declaringClass, MethodHandles.Lookup.PRIVATE).
      unreflectSpecial(method, declaringClass).
      bindTo(proxy).
      invokeWithArguments(args);

   return(result);
}