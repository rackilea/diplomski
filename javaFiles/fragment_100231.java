final Method method = 
    ReflectionUtil.getDeclaredMethod(SimpleJavaParameters.class, 
                                     "setUseClasspathJar", boolean.class);
if (method != null) {
  try {
    method.invoke(parameters, true);
  }
  catch (IllegalAccessException e1) {
    throw new RuntimeException(e1);
  }
  catch (InvocationTargetException e1) {
    throw new RuntimeException(e1);
  }
}