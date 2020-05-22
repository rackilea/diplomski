@RuntimeType
public Object intercept(@SuperCall Callable<?> zuper,
                        @Origin Method method) throws Exception {
  MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
  // interception stuff
  return zuper.call();
}