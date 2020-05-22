try {
    method.invoke
} catch (InvocationTargetException e) {
   Throwable mainException = e.getCause();
   if (mainException instanceof .....) {
   }
}