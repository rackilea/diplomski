System.out.println(Modifier.toString(myInterface.getModifiers())); // public abstract interface
System.out.println(myInterface.getSimpleName()); // MyInterface
System.out.println(Arrays.toString(myInterface.getDeclaredMethods())); // [public abstract void MyInterface.myMethod(java.lang.String)]

Method method = myInterface.getDeclaredMethod("myMethod", String.class);
System.out.println(method.getName()); // myMethod
System.out.println(Arrays.toString(method.getParameters())); // [java.lang.String myDeprecatedParameter]

Parameter parameter = method.getParameters()[0];
System.out.println(parameter); // java.lang.String myDeprecatedParameter
System.out.println(parameter.getName()); // myDeprecatedParameter
System.out.println(Arrays.toString(parameter.getAnnotations())); // [@java.lang.Deprecated()]

Annotation annotation = parameter.getAnnotations()[0];
System.out.println(annotation); // @java.lang.Deprecated()