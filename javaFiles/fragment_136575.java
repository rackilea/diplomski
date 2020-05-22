MyClass myClass = new MyClass();
Class objClass = myClass.getClass();
Set<Method> getMethods = new HashSet<Method>();

for (Method method : objClass.getMethods()) {
    if(method.getName().contains("getVar")) {
        getMethods.add(method);
    }
}