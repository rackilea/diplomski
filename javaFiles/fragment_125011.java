468 private Object executeMethod(final Method method, 
469                              final ApplicationContext context,
470                              final Object[] params) 
471         throws PrivilegedActionException, 
472                IllegalAccessException,
473                InvocationTargetException {
474                                  
475     if (SecurityUtil.isPackageProtectionEnabled()){
476        return AccessController.doPrivileged(new PrivilegedExceptionAction(){
477             public Object run() throws IllegalAccessException, InvocationTargetException{
478                 return method.invoke(context,  params);
479             }
480         });
481     } else {
482         return method.invoke(context, params);
483     }        
484 }