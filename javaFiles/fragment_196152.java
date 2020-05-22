Method m = findMethodWithAnnotation(clazz, DesiredAnnotation.class)
if (m == null) log("Nor the class, or any superclass have the desired annotation")
else {
    m.setAccessitble(true);
    m.invoke(obj, arguments);
}