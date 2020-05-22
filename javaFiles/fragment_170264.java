//Fully qualified name
String typeName = "com.yourcompany.product.Monster3";

try {
    //Class from name
    Class<?> myClass = Class.forName(typeName);

    //Constructor from Parameter types...
    Class<?>[] types = {Double.TYPE, String.class};
    Constructor constructor = myClass.getConstructor(types);

    //Instance from Parameter values...
    Object[] parameters = {new Double(0), "Hello"};
    Object instanceOfMyClass = constructor.newInstance(parameters);

} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
    ex.printStackTrace();
}