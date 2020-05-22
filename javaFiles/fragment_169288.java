Found a better way to do it,

A a= new J();
Method[] methods = a.getClass().getMethods();
for(Method method : methods) {
    System.out.println(method.getDeclaringClass() + " " + method.getName());
}