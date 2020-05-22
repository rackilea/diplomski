Class curClass = myclass.class;
Method[] allMethods = curClass.getMethods();
List<Method> setters = new ArrayList<Method>();
for(Method method : allMethods) {
    if(method.getName().startsWith("set")) {
        setters.add(method);
    }
}