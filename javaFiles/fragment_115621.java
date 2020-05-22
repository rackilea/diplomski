Method method = context.getMethod();
Annotation[][] annotations = method.getParameterAnnotations();
// iterate through annotations and check 
Object[] parameterValues = context.getParameters();

// check if annotation exists at each index
if (annotation[0].length > 0 /* and if the annotation is the type you want */ ) 
    // get the value of the parameter
    System.out.println(parameterValues[0]);