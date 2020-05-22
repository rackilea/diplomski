public void callServiceMethod(String serviceName, String methodName, Object... paramList){
Object service = ;//getting the service object by name
//getting the method
Method method = service.getClass().getMethod(methodName, paramList[0].class,...);

for ( Annotation a : m.getAnnotations() ) {
// if the annotation found then write to log
}
//in the end:
method.invoke(service , paramList[0], ...);
}