java.lang.reflect.Method method;
     method = pants.getClass().getMethod("eat", Long.class, Double.class, String.class);
    .
    .
    .
      method.invoke(pants,params );