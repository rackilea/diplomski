Map<Class<?>, Object> map = ... /* initialize */

for (Class cls : method.getParameterTypes()) {  
     for (Entry<Class<?>, Object> candidate : map.entrySet()) {
          if (candidate.getKey().isAssignableFrom(cls)) {
               arguments[i] = candidate.getValue()
               break; // continue with the next parameter type
          }
     }
}